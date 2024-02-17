package com.example.p2k24;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Clock2 extends AppCompatActivity {

    private Button startStopButton;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 5 * 60 * 1000; // 5 minutes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock2);

        startStopButton = findViewById(R.id.startStopButton);
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        Button sendButton = findViewById(R.id.sendButton);

        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                    countDownTimer = null;
                    startStopButton.setText("Start");
                } else {
                    startStopTimer();
                }
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                // Do something with the input texts
                Toast.makeText(Clock2.this, "Text 1: " + text1 + ", Text 2: " + text2, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startStopTimer() {
        startStopButton.setText("Stop");
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                // Update timer if needed
            }

            @Override
            public void onFinish() {
                Toast.makeText(Clock2.this, "Timer Finished!", Toast.LENGTH_SHORT).show();
                startStopButton.setText("Start");
                countDownTimer = null;
            }
        }.start();
    }
}
