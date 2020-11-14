package com.example.activityplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String workoutType = getIntent().getExtras().getString("workoutType");
        int seconds = getIntent().getExtras().getInt("seconds");

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainContainer, TimerFragment.newInstance(workoutType, seconds))
                .commit();
    }
}