package com.example.activityplayground;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.concurrent.Future;

import static android.os.Looper.getMainLooper;

public class TimerFragment extends Fragment{

    private TextView finishMessage;
    private int seconds = 0;
    private int workoutSeconds;
    // time in fragment layout
    private TextView workoutTextView;
    private TextView timeText;
    private FloatingActionButton timerButton;
    private boolean paused = true;  // first application is paused before running

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // finish textview
        finishMessage = view.findViewById(R.id.finish_message);

        // getting the arguments from bundle
        workoutTextView = view.findViewById(R.id.workout_title);
        timeText = view.findViewById(R.id.time_text);


        String workoutTitle = getArguments().getString("workoutType");
        workoutSeconds = getArguments().getInt("seconds");
        workoutTextView.setText(String.format(workoutTitle));
        timeText.setText(String.format("%02d : %02d : %02d", 00, 00, workoutSeconds));
        // timer button
        timerButton = view.findViewById(R.id.play_pause_fab);
        // timer starts when clicked
        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               paused = !paused;
               changeIcon();
               runTimer();
            }
        });
    }

    @Override
    public void onSaveInstanceState (@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
    }

    // button icon change
    public void changeIcon(){
        Drawable PLAY = getResources().getDrawable(android.R.drawable.ic_media_play);
        Drawable PAUSE = getResources().getDrawable(android.R.drawable.ic_media_pause);
        Drawable icon = paused ? PLAY : PAUSE;
        timerButton.setImageDrawable(icon);
    }


    public void runTimer(){
        final Handler handler = new Handler(getMainLooper());
        // schedules a piece of code that can run at a later time.

        handler.post(new Runnable() {
            @Override
            public void run() {
               //* int sec = seconds % 60*//*
                int sec = workoutSeconds % 60;
                int min = (sec % 3600) / 60;
                int hour = sec/60;
                timeText.setText(String.format("%02d : %02d : %02d", hour, min, sec));
                if(!paused){
                    workoutSeconds--;
                    if(workoutSeconds == 0){
                       /* handler.removeCallbacksAndMessages(null);*/
                        paused = true;
                        finishMessage.setText("Finished! Great Job!");
                    }
                    handler.postDelayed(this, 1000);  //runs the runnable again after a second
                }
            }
        });
    }

    public static TimerFragment newInstance(String workoutType, int seconds) {
        TimerFragment timerFragment = new TimerFragment();
        Bundle args = new Bundle();
        args.putString("workoutType", workoutType);
        args.putInt("seconds", seconds);
        timerFragment.setArguments(args);
        return timerFragment;
    }

}