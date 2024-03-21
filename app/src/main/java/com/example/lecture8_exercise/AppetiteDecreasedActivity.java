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

public class AppetiteDecreasedActivity extends AppCompatActivity {
    private String option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appetite_decreased);

        Button submitAppetiteDecrease = findViewById(R.id.submitAppetiteDecreased);
        submitAppetiteDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (option != null) {
                    MainActivity.addAnswer("Appetite (Decreased): "+option);
                    Intent messageIntent = new Intent(getApplicationContext(), WeightChangeActivity.class);
                    startActivity(messageIntent);
                } else {
                    Toast.makeText(AppetiteDecreasedActivity.this,
                            (String) getString(R.string.questions_unanswered_message),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void actionClick(View rb) {
        RadioButton choice = findViewById(rb.getId());
        option = choice.getText().toString();

        if (rb.getId() == R.id.appDec0) {
            AppetiteChangeActivity.setPoints(0);
            Log.d("App.Dec.0", "actionClick: "+option);
        } else if (rb.getId() == R.id.appDec1) {
            AppetiteChangeActivity.setPoints(1);
            Log.d("App.Dec.1", "actionClick: "+option);
        } else if (rb.getId() == R.id.appDec2) {
            AppetiteChangeActivity.setPoints(2);
            Log.d("App.Dec.2", "actionClick: "+option);
        } else if (rb.getId() == R.id.appDec3) {
            AppetiteChangeActivity.setPoints(3);
            Log.d("App.Dec.3", "actionClick: "+option);
        }
    }
}