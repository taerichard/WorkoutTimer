package com.example.activityplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
// once created it loads the fragment in the container

        int seconds = getIntent().getExtras().getInt("seconds");
        Log.i("INFO", "received seconds data " + seconds);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainContainer, TimerFragment.newInstance("Shoulders all day"))
                .commit();
    }
}