package cvnhan.android.androidtest;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends Activity {
    Handler handler;
    Runnable runnable;
    ActivityManager am;
    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);

        String address = getMacAddress(this);
        Log.e("MAC addr", address);
        mTextView.setText(address);



    }
    public void DectectNFCFelica(){
        if (isPackageInstalled("com.felicanetworks.mfc", getApplicationContext())) {
            mTextView.setText("Package Installed");

            am = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
            handler = new Handler();
            runnable = new Runnable() {
                @Override
                public void run() {
                    List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
                    String currentRunningActivityName = taskInfo.get(0).topActivity.getClassName();

                    if (currentRunningActivityName.contains("com.felicanetworks.adhoc")) {
                        mTextView.setText("ok");
                        Toast.makeText(getApplicationContext(), currentRunningActivityName, Toast.LENGTH_SHORT).show();

                        mTextView.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                Intent intent = new Intent(getBaseContext(),TempActivity.class);
//                        intent.setPackage("com.android.settings");
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK));
                                handler.removeCallbacks(runnable);
//                        finish();

                            }
                        },0);
                    } else {
                        handler.postDelayed(runnable, 1000);
                    }
                    Log.e("process: ", currentRunningActivityName);
                }
            };
            handler.postDelayed(runnable, 100);

        } else {
            mTextView.setText("No support");
        }

    }
    public static boolean isPackageInstalled(String packagename, Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
    public static String getMacAddress(Context context){
        WifiManager manager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();
        return info.getMacAddress();
    }
}
