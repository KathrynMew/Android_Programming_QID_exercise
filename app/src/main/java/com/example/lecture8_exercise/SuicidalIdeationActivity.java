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

public class SuicidalIdeationActivity extends AppCompatActivity {

    private String option;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suicidal_ideation);

        Button submitSI = findViewById(R.id.submitSuicideIdeation);
        submitSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (option != null) {
                    MainActivity.addAnswer("Suicidal Ideation: "+option);
                    MainActivity.updateScore(points);

                    Intent messageIntent = new Intent(getApplicationContext(), InterestActivity.class);
                    startActivity(messageIntent);
                } else {
                    Toast.makeText(SuicidalIdeationActivity.this,
                            (String) getString(R.string.questions_unanswered_message),
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void actionClick(View rb) {
        RadioButton choice = findViewById(rb.getId());
        option = choice.getText().toString();

        if (rb.getId() == R.id.suicide0) {
            points = 0;
            Log.d("suicide.0", "actionClick: "+option);
        } else if (rb.getId() == R.id.suicide1) {
            points = 1;
            Log.d("suicide.1", "actionClick: "+option);
        } else if (rb.getId() == R.id.suicide2) {
            points = 2;
            Log.d("suicide.2", "actionClick: "+option);
        } else if (rb.getId() == R.id.suicide3) {
            points = 3;
            Log.d("suicide.3", "actionClick: "+option);
        }
    }
}