package com.arabin.luanchdarkly_arabin_sse.ui.fragments.helper;

import androidx.navigation.NavOptions;

/**
 * @author Arabin
 * An Util class
 * used for fragment tansaction anim
 * */
public class NavigationHelper {

    public static NavOptions getNavigationOption(){
        return new NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setEnterAnim(androidx.navigation.ui.R.anim.nav_default_enter_anim)
                .setExitAnim(androidx.navigation.ui.R.anim.nav_default_exit_anim)
                .setPopEnterAnim(androidx.navigation.ui.R.anim.nav_default_pop_enter_anim)
                .setPopExitAnim(androidx.navigation.ui.R.anim.nav_default_pop_exit_anim)
                .build();
    }

}
