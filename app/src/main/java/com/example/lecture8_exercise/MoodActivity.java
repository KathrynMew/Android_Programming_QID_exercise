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

public class MoodActivity extends AppCompatActivity {
    private String option;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        Button submitMood = findViewById(R.id.submitMood);
        submitMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (option != null){
                    MainActivity.addAnswer("Mood (Sad): "+option);
                    MainActivity.updateScore(points);

                    Intent messageIntent = new Intent(getApplicationContext(), AppetiteChangeActivity.class);
                    startActivity(messageIntent);
                } else {
                    Toast.makeText(MoodActivity.this,
                            (String) getString(R.string.questions_unanswered_message),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void actionClick(View rb) {
        RadioButton choice = findViewById(rb.getId());
        option = choice.getText().toString();

        if (rb.getId() == R.id.mood0) {
            points = 0;
            Log.d("mood.0", "actionClick: "+option);
        } else if (rb.getId() == R.id.mood1) {
            points = 1;
            Log.d("mood.1", "actionClick: "+option);
        } else if (rb.getId() == R.id.mood2) {
            points = 2;
            Log.d("mood.2", "actionClick: "+option);
        } else if (rb.getId() == R.id.mood3) {
            points = 3;
            Log.d("mood.3", "actionClick: "+option);
        }
    }
}