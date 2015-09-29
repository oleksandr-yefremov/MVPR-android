/*
 * Copyright (c) Oleksandr Yefremov (yefremov.oleksandr@gmail.com)
 */

package io.github.oleksandr_yefremov.mvpr_android.application;

import android.app.Application;

import io.github.oleksandr_yefremov.mvpr_android.router.Router;
import io.github.oleksandr_yefremov.mvpr_android.router.RouterInterface.DiscoverRouterInterface;

/**
 *
 */
public class ViperApp extends Application {

	Router router = new Router();

	@Override
	public void onCreate() {
		super.onCreate();


	}

	public DiscoverRouterInterface provideDiscoverRouter() {
		return router;
	}
}
