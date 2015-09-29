/*
 * Copyright (c) Oleksandr Yefremov (yefremov.oleksandr@gmail.com)
 */
package io.github.oleksandr_yefremov.mvpr_android.router;

import android.app.FragmentManager;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;

import io.github.oleksandr_yefremov.mvpr_android.router.RouterInterface.DiscoverRouterInterface;
import io.github.oleksandr_yefremov.mvpr_android.view.fragment.DiscoverFragment;

/**
 *
 */
public class Router implements DiscoverRouterInterface {

	//	public void presentFragment(BaseView view) {
//		actionBarLayout.presentFragment(view);
//	}
//
	@Override
	public void presentDiscoverView(@IdRes int containerViewId, @NonNull FragmentManager fragmentManager) {
		fragmentManager.beginTransaction()
		               .add(containerViewId, new DiscoverFragment())
		               .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
		               .commit();
	}

}
