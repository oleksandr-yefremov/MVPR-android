/*
 * Copyright (c) Oleksandr Yefremov (yefremov.oleksandr@gmail.com)
 */

package io.github.oleksandr_yefremov.viperandroid.presenter;

import android.util.Log;

import io.github.oleksandr_yefremov.viperandroid.view.fragment.DiscoverFragment;
import nucleus.presenter.RxPresenter;

/**
 *
 */
public class DiscoverPresenter extends RxPresenter<DiscoverFragment> {

	private static final int REQUEST_ITEMS = 1;
	private static final String TAG = DiscoverPresenter.class.getSimpleName();

	public void request() {
		start(REQUEST_ITEMS);
	}

	public void recyclerViewItemClicked(long clickItemId) {
		Log.d(TAG, "recyclerViewItemClicked : " + clickItemId);
//		childAt
	}
}
