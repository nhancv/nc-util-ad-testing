package cvnhan.android.androidtest;

import timber.log.Timber;

/**
 * Created by NhanCao on 4/30/2015.
 */
public class Vehicle {
    private Motor motor;
    public Vehicle(Motor motor){
        this.motor=motor;
    }
    public void initRPM(){
        motor.setRpm(10);
    }
    public void getRPMVehicle(){
        Timber.e("RPM Vehicle "+motor.getRpm());
    }
}
