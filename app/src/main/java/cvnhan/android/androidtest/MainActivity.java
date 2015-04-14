package cvnhan.android.androidtest;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends Activity {
    Handler handler;
    Runnable runnable;
    ActivityManager am;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        if (isPackageInstalled("com.felicanetworks.mfc", getApplicationContext())) {
            textView.setText("Package Installed");

            am = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
            handler = new Handler();
            runnable = new Runnable() {
                @Override
                public void run() {

                    List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
                    String currentRunningActivityName = taskInfo.get(0).topActivity.getClassName();

                    if (currentRunningActivityName.contains("com.felicanetworks.adhoc")) {
                        textView.setText("ok");
                        Toast.makeText(getApplicationContext(), currentRunningActivityName, Toast.LENGTH_SHORT).show();

//                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        Intent intent = new Intent();
                        intent.setPackage("com.android.settings");
                        intent.setAction(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_LAUNCHER);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        handler.removeCallbacks(runnable);
                        finish();
                    } else {
                        handler.postDelayed(runnable, 1000);
                    }
                    Log.e("process: ", currentRunningActivityName);
                }
            };
            handler.postDelayed(runnable, 100);

        } else {
            textView.setText("No support");
        }
    }

    private boolean isPackageInstalled(String packagename, Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
