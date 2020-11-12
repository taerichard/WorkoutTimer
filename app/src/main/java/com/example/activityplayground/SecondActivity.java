package com.example.activityplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    String workoutType;
    TextView workoutTitle;
    int seconds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
// once created it loads the fragment in the container

        workoutTitle = findViewById(R.id.workout_title);

        workoutType = getIntent().getStringExtra("workoutType");
        seconds = getIntent().getExtras().getInt("seconds");

        // changing workout title
        workoutTitle.setText(String.format(workoutType));
        Log.i("INFO", "Received seconds data " + seconds);
        Log.i("INFO", "Received string data " + workoutType);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainContainer, TimerFragment.newInstance(workoutType, seconds))
                .commit();
    }
}