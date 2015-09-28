/*
 * Copyright (c) Oleksandr Yefremov (yefremov.oleksandr@gmail.com)
 */

package io.github.oleksandr_yefremov.viperandroid.application;

import android.app.Application;

import io.github.oleksandr_yefremov.viperandroid.router.Router;
import io.github.oleksandr_yefremov.viperandroid.router.RouterInterface.DiscoverRouterInterface;

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
