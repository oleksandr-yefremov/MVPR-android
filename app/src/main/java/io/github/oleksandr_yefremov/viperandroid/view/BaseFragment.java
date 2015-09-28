/*
 * Copyright (c) Oleksandr Yefremov (yefremov.oleksandr@gmail.com)
 */

package io.github.oleksandr_yefremov.viperandroid.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.oleksandr_yefremov.viperandroid.view.fragment.LoggingFragment;
import nucleus.presenter.Presenter;

/**
 *
 */
public class BaseFragment<PresenterType extends Presenter> extends LoggingFragment<PresenterType> {

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return null;
	}
}
