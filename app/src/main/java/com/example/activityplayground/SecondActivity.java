package com.example.activityplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
// once created it loads the fragment in the container

        String workoutType = getIntent().getStringExtra("workoutType");
        int seconds = getIntent().getExtras().getInt("seconds");
        Log.i("INFO", "Received seconds data " + seconds);
        Log.i("INFO", "Received string data " + workoutType);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainContainer, TimerFragment.newInstance())
                .commit();
    }
}