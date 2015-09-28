/*
 * Copyright (c) Oleksandr Yefremov (yefremov.oleksandr@gmail.com)
 */
package io.github.oleksandr_yefremov.viperandroid.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;

import io.github.oleksandr_yefremov.viperandroid.R;
import io.github.oleksandr_yefremov.viperandroid.application.ViperApp;
import io.github.oleksandr_yefremov.viperandroid.router.RouterInterface.DiscoverRouterInterface;
import io.github.oleksandr_yefremov.viperandroid.view.ActionBarLayout;

/**
 * Single activity that is used throughout the app. All screens are defined as Fragments and Views.
 */
public class MainActivity
//	extends NucleusAppCompatActivity<MainPresenter>
	extends Activity {

	ViperApp application;
	private ActionBarLayout rootLayout;
	// Phone rootLayout will have one stack of views,
	// while Tablet may have separate stacks on each layout
	private ActionBarLayout tabletLeftLayout;
	private ActionBarLayout tabletRightLayout;

	private DiscoverRouterInterface router;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// create empty layout
		rootLayout = new ActionBarLayout(this);
		rootLayout.setId(R.id.containerView);
		// set Activity content to it
		setContentView(rootLayout, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

		// get Router
		application = (ViperApp) getApplication();
		router = application.provideDiscoverRouter();

		// navigate to DiscoverView.
		// This is the entry point of application, we have to route to first screen somewhere.
		// Activity isn't aware of any other navigation
		if (savedInstanceState == null) {
			router.presentDiscoverView(rootLayout.getId(), getFragmentManager()); // may be changed to tabletLeft(Right)Layout
		}
	}
}
