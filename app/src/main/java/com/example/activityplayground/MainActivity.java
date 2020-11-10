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
    TimerFragment timerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shoulderButton = findViewById(R.id.button_shoulders);
        shoulderButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("INFO", "BUTTON CLICKED FROM ACTIVITY");
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

        switch(v.getId()){
            case R.id.button_shoulders : {
                intent.putExtra("seconds", 30);
                startActivity(intent);
            }
            default:{
                break;
            }
        }
    }
}