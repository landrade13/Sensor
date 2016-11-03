package com.example.android.sensor;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.content.Context.SENSOR_SERVICE;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    LinearLayout lin;
    SensorManager senso;
    Sensor sensor;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lin=(LinearLayout) findViewById(R.id.liner);
        tv=(TextView) findViewById(R.id.text);
        senso=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=senso.getDefaultSensor(Sensor.TYPE_PROXIMITY);






    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String text=String.valueOf(event.values[0]);
        tv.setText(text);

        float val=Float.parseFloat(text);

        if (val==0){
            lin.setBackgroundColor(Color.BLUE);
        }else{
            lin.setBackgroundColor(Color.YELLOW);

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
