package cvnhan.android.androidtest;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by NhanCao on 4/30/2015.
 */
public class App extends Application{

    private MainComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        if(isDebug()){
            Timber.plant(new Timber.DebugTree());
        }
        component=DaggerMainComponent.builder().build();


    }
    private boolean isDebug(){
        return BuildConfig.DEBUG;
    }
    public MainComponent getComponent(){
        return component;
    }
}
