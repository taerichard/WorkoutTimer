package com.example.activityplayground;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.os.Looper.getMainLooper;

public class TimerFragment extends Fragment {

    int seconds = 0;
    static TextView tv;
    static TextView workoutTitle;
    boolean paused = true;
    FloatingActionButton fab;
    int minutes = 15;
    int startingTime = 5;
    Drawable PLAY;
    Drawable PAUSE;


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        workoutTitle = view.findViewById(R.id.workout_title);
        Log.i("INFO", workoutTitle.toString());

        tv = view.findViewById(R.id.time_text);
        fab = view.findViewById(R.id.play_pause_fab);
        PLAY = getResources().getDrawable(android.R.drawable.ic_media_play);
        PAUSE = getResources().getDrawable(android.R.drawable.ic_media_pause);
        if (savedInstanceState != null) {
            paused = savedInstanceState.getBoolean("paused");
            seconds = savedInstanceState.getInt("seconds");
            setIcon();
        }
        runTimer();
    }

    public static TimerFragment newInstance(String workout) {
        TimerFragment fragment = new TimerFragment();
/*
        workoutTitle.setText(workout);
*/

        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private void setIcon () {
        Drawable icon = paused ? PLAY : PAUSE;
        fab.setImageDrawable(icon);
    }

    @Override
    public void onSaveInstanceState (@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("paused", paused);
    }

    public void startTimer (View view){
        paused = !paused;
        setIcon();
    }

    public void runTimer () {
        // handler can schedule some code to run at a periodic manner aka timer
        final Handler handler = new Handler(getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.i("INFO","run TIMER");
                int sec = seconds % 60;
                int min = (seconds % 3600) / 60;
                int hour = seconds / 3660;
                tv.setText(String.format("%02d : %02d : %02d", hour, min, sec));
                if (!paused)
                    seconds++;
                    handler.postDelayed(this, 1000);
                }
            });
    }

}