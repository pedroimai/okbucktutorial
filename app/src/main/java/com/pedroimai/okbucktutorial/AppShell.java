//package com.pedroimai.archcomp;
//
//import android.app.Activity;
//
//import com.facebook.buck.android.support.exopackage.ExopackageApplication;
//import com.pedroimai.archcomp.di.CoreModule;
//import com.pedroimai.archcomp.di.DaggerCoreComponent;
//
//import javax.inject.Inject;
//import dagger.android.DispatchingAndroidInjector;
//import dagger.android.HasActivityInjector;
//
//public class AppShell extends ExopackageApplication implements HasActivityInjector {
//    @Inject
//    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
//
//
//    public AppShell() {
//        super(BuildConfig.EXOPACKAGE_FLAGS == 1);
//        DaggerCoreComponent.builder()
//                .coreModule(new CoreModule(this))
//                .build()
//                .inject(this);
//
//    }
//
//    @Override
//    public DispatchingAndroidInjector<Activity> activityInjector() {
//        return activityDispatchingAndroidInjector;
//    }
//}


package com.pedroimai.okbucktutorial;

import androidx.multidex.MultiDex;
import com.facebook.buck.android.support.exopackage.ExopackageApplication;

public class AppShell extends ExopackageApplication {

    public AppShell() {
        super(BuildConfig.EXOPACKAGE_FLAGS == 1);
    }

    @Override
    protected void onBaseContextAttached() {
        if (!(BuildConfig.EXOPACKAGE_FLAGS == 1)) {
            MultiDex.install(this);
        }
    }
}