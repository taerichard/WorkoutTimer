package com.example.activityplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public final static String SHOULDER_WORKOUT = "Shoulders";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       findViewById(R.id.button_shoulders).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch(v.getId()){
            case R.id.button_shoulders :{
                intent = new Intent(this, Timer.class);
                intent.putExtra(SHOULDER_WORKOUT, "Shoulder Work");
                startActivity(intent);
                break;
            }
            default : {
                break;
            }
        }


    }
}