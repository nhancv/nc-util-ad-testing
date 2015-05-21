package cvnhan.android.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;


public class MainActivity extends Activity {
    @Inject
    Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.tag(getClass().getSimpleName());
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        ((App) getApplication()).getComponent().inject(this);

//        Timber.e("begin dagger 2 for vehicle");
//        vehicle.getRPMVehicle();
//        vehicle.initRPM();
//        vehicle.getRPMVehicle();
//        Timber.e("end dagger 2 for vehicle");
    }

    @OnClick(R.id.btn)
    public void clickBtn(Button btn) {
        btn.setText("Hello world!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
    }
}
