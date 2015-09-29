/*
 * Copyright (c) Oleksandr Yefremov (yefremov.oleksandr@gmail.com)
 */

package io.github.oleksandr_yefremov.mvpr_android.view.fragment;

import android.os.Bundle;
import android.view.View;

import nucleus.presenter.Presenter;
import nucleus.view.NucleusFragment;

import static android.util.Log.v;

public class LoggingFragment<PresenterType extends Presenter> extends NucleusFragment<PresenterType> {

	private final String TAG = getClass().getSimpleName();

	public LoggingFragment() {
		v(TAG, "constructor : " + hashCode());
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		v(TAG, "onCreate hashCode() : " + hashCode() +
		       "|" + " savedInstanceState : " + savedInstanceState);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		v(TAG, "onDestroy : " + hashCode());
	}

	@Override
	public void onSaveInstanceState(Bundle bundle) {
		super.onSaveInstanceState(bundle);
		v(TAG, "onSaveInstanceState " + bundle);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		v(TAG, "onViewCreated : " + hashCode());
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		v(TAG, "onDestroyView : " + hashCode());
	}

	@Override
	public void onResume() {
		super.onResume();
		v(TAG, "onResume : " + hashCode());
	}

	@Override
	public void onPause() {
		super.onPause();
		v(TAG, "onPause : " + hashCode());
	}
}
