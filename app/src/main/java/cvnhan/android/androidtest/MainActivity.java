package cvnhan.android.androidtest;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import timber.log.Timber;


public class MainActivity extends Activity {
    @Inject
    Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.tag(getClass().getSimpleName());
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getComponent().inject(this);

        Timber.e("begin dagger 2 for vehicle");
        vehicle.getRPMVehicle();
        vehicle.initRPM();
        vehicle.getRPMVehicle();
        Timber.e("end dagger 2 for vehicle");
    }
}
