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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        runTimer();
    }

    public void runTimer(){
        Handler handler = new Handler(getMainLooper());
        // schedules a piece of code that can run at a later time.
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.i("INFO", "Runnable");
                handler.postDelayed(this, 1000);
            }
        });
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public static TimerFragment newInstance(String workout) {
        TimerFragment timerFragment = new TimerFragment();
        Bundle args = new Bundle();
        args.putString("workout", workout);
        timerFragment.setArguments(args);
        return timerFragment;
    }

    @Override
    public void onSaveInstanceState (@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
    }




}