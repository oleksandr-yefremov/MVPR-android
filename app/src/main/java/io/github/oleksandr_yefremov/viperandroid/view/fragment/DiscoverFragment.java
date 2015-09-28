/*
 * Copyright (c) Oleksandr Yefremov (yefremov.oleksandr@gmail.com)
 */
package io.github.oleksandr_yefremov.viperandroid.view.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.oleksandr_yefremov.viperandroid.R;
import io.github.oleksandr_yefremov.viperandroid.presenter.DiscoverPresenter;
import io.github.oleksandr_yefremov.viperandroid.view.BaseFragment;
import io.github.oleksandr_yefremov.viperandroid.view.recyclerview.RecyclerItemClickListener;
import io.github.oleksandr_yefremov.viperandroid.view.recyclerview.RecyclerItemClickListener.OnItemClickListener;
import io.github.oleksandr_yefremov.viperandroid.view.viewholder.DiscoverCardAdapter;
import nucleus.factory.RequiresPresenter;

/**
 *
 */
@RequiresPresenter(DiscoverPresenter.class)
public class DiscoverFragment extends BaseFragment<DiscoverPresenter> {

	private final static int PHONE_PORTRAIT_SPANCOUNT = 2;
	private final static int PHONE_LANDSCAPE_SPANCOUNT = 3;
	private final static int PHABLET_PORTRAIT_SPANCOUNT = 3;
	private final static int PHABLET_LANDSCAPE_SPANCOUNT = 4;
	private final static int TABLET_PORTRAIT_SPANCOUNT = 3;
	private final static int TABLET_LANDSCAPE_SPANCOUNT = 5;

	private DiscoverPresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		if (bundle == null) {
//			DiscoverPresenter presenter = getPresenter();
//			if (presenter != null) {
//				presenter.request();
//			}
//		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_discover_view, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		presenter = getPresenter();

		int orientation = getResources().getConfiguration().orientation;
		int currentSpanCount = PHONE_PORTRAIT_SPANCOUNT;
		switch (orientation) {
			case Configuration.ORIENTATION_UNDEFINED:
			case Configuration.ORIENTATION_PORTRAIT:
				currentSpanCount = PHONE_PORTRAIT_SPANCOUNT;
				break;
			case Configuration.ORIENTATION_LANDSCAPE:
				currentSpanCount = PHONE_LANDSCAPE_SPANCOUNT;
				break;

		}

		final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
		recyclerView.setHasFixedSize(true);

		GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), currentSpanCount);
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(layoutManager);

		final DiscoverCardAdapter adapter = new DiscoverCardAdapter();
		recyclerView.setAdapter(adapter);
		recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(null, new OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				presenter.recyclerViewItemClicked(adapter.getItemId(position));
			}
		}));
	}

	//	public void onItems(List<DiscoverItems>)
	//	@Override
//	protected void onAttachedToWindow() {
//		super.onAttachedToWindow();
//
//		LayoutInflater.from(getContext()).inflate(R.layout.view_tracklist, this);
//	}
}
