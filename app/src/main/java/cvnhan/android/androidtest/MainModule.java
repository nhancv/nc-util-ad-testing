package cvnhan.android.androidtest;

import dagger.Module;
import dagger.Provides;

/**
 * Created by NhanCao on 4/30/2015.
 */
@Module
public class MainModule {
    @Provides
    Vehicle provideVehicle(){
        return new Vehicle(new Motor());
    }

}
