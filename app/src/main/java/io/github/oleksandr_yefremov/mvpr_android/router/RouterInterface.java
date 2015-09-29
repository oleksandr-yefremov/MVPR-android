package io.github.oleksandr_yefremov.mvpr_android.router;

import android.app.FragmentManager;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;

/**
 * Oleksandr Yefremov (oleksandr@nativ.com)
 */
public class RouterInterface {

	public interface DiscoverRouterInterface {
		/**
		 * @param containerViewId Fragment is to be added to this container
		 * @param fragmentManager
		 */
		void presentDiscoverView(@IdRes int containerViewId, @NonNull FragmentManager fragmentManager);
	}
}
