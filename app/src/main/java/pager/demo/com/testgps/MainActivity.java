package pager.demo.com.testgps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import net.alexandroid.gps.GpsStatusDetector;

public class MainActivity extends AppCompatActivity implements GpsStatusDetector.GpsStatusDetectorCallBack {

    GpsStatusDetector mGpsStatusDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGpsStatusDetector = new GpsStatusDetector(this);
        mGpsStatusDetector.checkGpsStatus();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mGpsStatusDetector.checkOnActivityResult(requestCode, resultCode);
    }
    @Override
    public void onGpsSettingStatus(boolean enabled) {
        Log.d("TAG", "onGpsSettingStatus: " + enabled);
        Toast.makeText(this,"Gps on",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGpsAlertCanceledByUser() {
        Toast.makeText(this,"Cancel by user",Toast.LENGTH_LONG).show();
        Log.d("TAG", "onGpsAlertCanceledByUser");
    }
}
