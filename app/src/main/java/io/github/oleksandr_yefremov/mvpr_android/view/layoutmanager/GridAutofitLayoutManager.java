/*
 * Copyright (c) s.maks (http://stackoverflow.com/users/1315647/s-maks)
 * Modified from http://stackoverflow.com/a/30256880/1237733
 * by Oleksandr Yefremov (yefremov.oleksandr@gmail.com)
 */

package io.github.oleksandr_yefremov.mvpr_android.view.layoutmanager;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

/**
 *
 */
public class GridAutofitLayoutManager extends GridLayoutManager
{
	private int mColumnWidth;
	private boolean mColumnWidthChanged = true;

	public GridAutofitLayoutManager(Context context, int columnWidth)
	{
        /* Initially set spanCount to 1, will be changed automatically later. */
		super(context, 1);
		setColumnWidth(checkedColumnWidth(context, columnWidth));
	}

	public GridAutofitLayoutManager(Context context, int columnWidth, int orientation, boolean reverseLayout)
	{
        /* Initially set spanCount to 1, will be changed automatically later. */
		super(context, 1, orientation, reverseLayout);
		setColumnWidth(checkedColumnWidth(context, columnWidth));
	}

	private int checkedColumnWidth(Context context, int columnWidth)
	{
		if (columnWidth <= 0)
		{
            /* Set default columnWidth value (48dp here). It is better to move this constant
            to static constant on top, but we need context to convert it to dp, so can't really
            do so. */
			columnWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48,
			                                              context.getResources().getDisplayMetrics());
		}
		return columnWidth;
	}

	public void setColumnWidth(int newColumnWidth)
	{
		if (newColumnWidth > 0 && newColumnWidth != mColumnWidth)
		{
			mColumnWidth = newColumnWidth;
			mColumnWidthChanged = true;
		}
	}

	@Override
	public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state)
	{
		if (mColumnWidthChanged && mColumnWidth > 0)
		{
			int totalSpace;
			if (getOrientation() == VERTICAL)
			{
				totalSpace = getWidth() - getPaddingRight() - getPaddingLeft();
			}
			else
			{
				totalSpace = getHeight() - getPaddingTop() - getPaddingBottom();
			}
			int spanCount = Math.max(1, totalSpace / mColumnWidth);
			setSpanCount(spanCount);
			mColumnWidthChanged = false;
		}
		super.onLayoutChildren(recycler, state);
	}
}