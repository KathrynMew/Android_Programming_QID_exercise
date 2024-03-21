package com.example.lecture8_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class AppetiteIncreasedActivity extends AppCompatActivity {

    private String option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appetite_increased);

        Intent appetiteChangeMessage = getIntent();

        Button submitAppetiteIncrease = findViewById(R.id.submitAppetiteIncreased);
        submitAppetiteIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (option != null) {
                    MainActivity.addAnswer("Appetite (Increased): "+option);

                    Intent messageIntent = new Intent(getApplicationContext(), WeightChangeActivity.class);
                    startActivity(messageIntent);
                } else {
                    Toast.makeText(AppetiteIncreasedActivity.this,
                            (String) getString(R.string.questions_unanswered_message),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void actionClick(View rb) {
        RadioButton choice = findViewById(rb.getId());
        option = choice.getText().toString();

        if (rb.getId() == R.id.appInc0) {
            AppetiteChangeActivity.setPoints(0);
            Log.d("App.Inc.0", "actionClick: "+option);
        } else if (rb.getId() == R.id.appInc1) {
            AppetiteChangeActivity.setPoints(1);
            Log.d("App.Inc.1", "actionClick: "+option);
        } else if (rb.getId() == R.id.appInc2) {
            AppetiteChangeActivity.setPoints(2);
            Log.d("App.Inc.2", "actionClick: "+option);
        } else if (rb.getId() == R.id.appInc3) {
            AppetiteChangeActivity.setPoints(3);
            Log.d("App.Inc.3", "actionClick: "+option);
        }
    }
}