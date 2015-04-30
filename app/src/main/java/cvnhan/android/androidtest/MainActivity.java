package cvnhan.android.androidtest;

import android.app.Activity;
import android.os.Bundle;

import timber.log.Timber;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.tag(getClass().getSimpleName());
        setContentView(R.layout.activity_main);

    }

}
