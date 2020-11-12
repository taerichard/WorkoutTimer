package com.example.activityplayground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Timer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button shoulderButton;
    Button legButton;
    Button chestButton;
    TimerFragment timerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // shoulder button
        shoulderButton = findViewById(R.id.button_shoulders);
        shoulderButton.setOnClickListener(this);

        // chest button
        chestButton = findViewById(R.id.chest_button);
        chestButton.setOnClickListener(this);
        // leg button
        legButton = findViewById(R.id.legs_button);
        legButton.setOnClickListener(this);
    }

    public Intent addData(String workout, int sec){
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("workoutType", workout);
        intent.putExtra("seconds", sec);
        return intent;
    }

    @Override
    public void onClick(View v) {
        Log.i("INFO", "BUTTON CLICKED FROM ACTIVITY");

        switch(v.getId()){
            case R.id.button_shoulders : {
                Intent intent = addData("Shoulder Workout", 30);
                startActivity(intent);
            }
            case R.id.legs_button : {
                Intent intent = addData("Leg Workout", 100);
                startActivity(intent);
            }
            case R.id.chest_button : {
               Intent intent = addData("Chest Workout", 15);
                startActivity(intent);
            }
            default:{
                break;
            }
        }
    }
}