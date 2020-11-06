package com.example.activityplayground;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Timer extends AppCompatActivity {
    private int seconds = 0;
    private TextView tv;
    private boolean paused = true;
    private FloatingActionButton fab;
    private int minutes = 15;
    private int startingTime = 5;
    private Drawable PLAY;
    private Drawable PAUSE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        Intent intent = getIntent();
        String workoutType = intent.getStringExtra(MainActivity.SHOULDER_WORKOUT);
        Log.i("INFO", workoutType);
        changeWorkoutTitle(workoutType);

        tv = findViewById(R.id.time_text);
        fab = findViewById(R.id.play_pause_fab);
        PLAY = getResources().getDrawable(android.R.drawable.ic_media_play);
        PAUSE = getResources().getDrawable(android.R.drawable.ic_media_pause);
        if (savedInstanceState != null) {
            paused = savedInstanceState.getBoolean("paused");
            seconds = savedInstanceState.getInt("seconds");
            setIcon();
        }
        runTimer();
    }

    public void changeWorkoutTitle(String workout){
        TextView workoutTitle =  findViewById(R.id.workout_title);
        workoutTitle.setText(String.format(workout));
    }

    private void setIcon() {
        Drawable icon = paused ? PLAY : PAUSE;
        fab.setImageDrawable(icon);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("paused", paused);
    }

    public void startTimer(View view) {
        paused = !paused;
        setIcon();


    }

    public void runTimer() {
        // handler can schedule some code to run at a periodic manner aka timer
        final Handler handler = new Handler(getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                int sec = seconds % 60;
                int min = (seconds % 3600) / 60;
                int hour = seconds / 3660;
                tv.setText(String.format("%02d : %02d : %02d", hour, startingTime, sec));
                if (!paused) seconds++;
                handler.postDelayed(this, 1000);


            }
        });
    }
}