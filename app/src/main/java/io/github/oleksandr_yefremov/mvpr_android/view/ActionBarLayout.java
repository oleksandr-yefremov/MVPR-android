/*
 * Copyright (c) Oleksandr Yefremov (yefremov.oleksandr@gmail.com)
 */

package io.github.oleksandr_yefremov.mvpr_android.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.internal.widget.ActionBarContainer;
import android.widget.FrameLayout;

/**
 *
 */
public class ActionBarLayout extends FrameLayout {
	private final Activity parentActivity;

	public ActionBarLayout(Context context) {
		super(context);

		parentActivity = (Activity) context;
		ActionBarContainer actionBarContainer = new ActionBarContainer(context);
		addView(actionBarContainer);
	}



	public boolean presentView(BaseFragment fragment) {
		return false;
	}

}
