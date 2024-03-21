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

public class FatigueActivity extends AppCompatActivity {

    private String fatigueOption;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatigue);

        Button submitFati = findViewById(R.id.submitFatigue);
        submitFati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fatigueOption != null) {
                    MainActivity.addAnswer("Fatigue: "+fatigueOption);
                    MainActivity.updateScore(points);

                    Intent messageIntent = new Intent(getApplicationContext(), PsychomotorChangesActivity.class);
                    startActivity(messageIntent);
                } else {
                    Toast.makeText(FatigueActivity.this,
                            (String) getString(R.string.questions_unanswered_message),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void actionClick(View rb) {
        RadioButton choice = findViewById(rb.getId());
        fatigueOption = choice.getText().toString();

        if (rb.getId() == R.id.fati0) {
            points = 0;
            Log.d("Fati_0", "actionClick: "+fatigueOption);
        } else if (rb.getId() == R.id.fati1) {
            points = 1;
            Log.d("Fati_1", "actionClick: "+fatigueOption);
        } else if (rb.getId() == R.id.fati2) {
            points = 2;
            Log.d("Fati_2", "actionClick: "+fatigueOption);
        } else if (rb.getId() == R.id.fati3) {
            points = 3;
            Log.d("Fati_3", "actionClick: "+fatigueOption);
        }
    }
}