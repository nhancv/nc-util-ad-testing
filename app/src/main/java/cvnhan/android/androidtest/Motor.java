package cvnhan.android.androidtest;

import javax.inject.Inject;

/**
 * Created by NhanCao on 4/30/2015.
 */
public class Motor {
    private int rpm;

    @Inject
    public Motor() {
        rpm = -1;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm=rpm;
    }
}
