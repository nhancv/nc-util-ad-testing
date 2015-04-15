package cvnhan.android.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class Temp2Activity extends Activity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

        textView.setText("third");
        textView.postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent=new Intent(getApplicationContext(), Temp2Activity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK|
//                                Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
                finish();
            }
        },100);
    }
}
