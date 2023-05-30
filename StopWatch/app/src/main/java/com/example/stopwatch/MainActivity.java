package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;
import android.view.View;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private Button stopButton;
    private Button holdButton;
    private TextView timerTextView;

    private Timer timer;
    private TimerTask timerTask;
    private long startTime = 0L;
    private long elapsedTime = 0L;
    private boolean isRunning = false;

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        holdButton = findViewById(R.id.holdButton);
        timerTextView = findViewById(R.id.timerTextView);

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                elapsedTime = System.currentTimeMillis() - startTime;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        updateTimerText(elapsedTime);
                    }
                });
            }
        };

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isRunning) {
                    startTime = System.currentTimeMillis() - elapsedTime;
                    timer = new Timer();
                    timerTask = new TimerTask() {
                        @Override
                        public void run() {
                            elapsedTime = System.currentTimeMillis() - startTime;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    updateTimerText(elapsedTime);
                                }
                            });
                        }
                    };
                    timer.scheduleAtFixedRate(timerTask, 0L, 100L);
                    isRunning = true;
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRunning) {
                    timer.cancel();
                    timerTask.cancel();
                    isRunning = false;
                } else {
                    elapsedTime = 0L;
                    updateTimerText(elapsedTime);
                }
            }
        });

        holdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRunning) {
                    timer.cancel();
                    timerTask.cancel();
                    isRunning = false;
                } else {
                    startTime = System.currentTimeMillis() - elapsedTime;
                    timer = new Timer();
                    timerTask = new TimerTask() {
                        @Override
                        public void run() {
                            elapsedTime = System.currentTimeMillis() - startTime;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    updateTimerText(elapsedTime);
                                }
                            });
                        }
                    };
                    timer.scheduleAtFixedRate(timerTask, 0L, 100L);
                    isRunning = true;
                }
            }
        });
    }

    private void updateTimerText(long time) {
        int seconds = (int) (time / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        int milliseconds = (int) (time / 100) % 10; // get tenths of a second
        timerTextView.setText(String.format(Locale.getDefault(), "%02d:%02d.%2d", minutes, seconds, milliseconds));
    }
}
