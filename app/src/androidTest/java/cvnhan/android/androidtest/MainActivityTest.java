package cvnhan.android.androidtest;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

/**
 * Created by cvnhan on 21-May-15.
 */
@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2 <MainActivity>{

    public MainActivityTest() {
        super(MainActivity.class);
    }
}