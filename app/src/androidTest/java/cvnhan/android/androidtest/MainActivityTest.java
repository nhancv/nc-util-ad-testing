package cvnhan.android.androidtest;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by cvnhan on 21-May-15.
 */
@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2 <MainActivity>{

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testCase(){
        onView(withText("Hello world!")).check(matches(isDisplayed()));
    }
    public void testCase2() {
        onView(withText("aklsdfj")).check(matches(isDisplayed()));
        onView(withText("aklsdfj")).perform(click());
        onView(withId(R.id.btn)).check(matches(withText("Hello world!")));
    }
}