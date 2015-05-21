package cvnhan.android.androidtest;

import dagger.Component;

/**
 * Created by NhanCao on 4/30/2015.
 */
@Component (modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);

}
