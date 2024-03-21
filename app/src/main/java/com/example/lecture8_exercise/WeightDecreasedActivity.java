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

public class WeightDecreasedActivity extends AppCompatActivity {
    private String option;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_decreased);

        Intent weightChangeMessage = getIntent();
        /*int currentScore = weightChangeMessage.getIntExtra("score", 0);
        int appetiteScore = weightChangeMessage.getIntExtra("appetiteScore", 0);
        ArrayList<String> weightAnswers = weightChangeMessage.getStringArrayListExtra("appetiteAnswers");*/

        Button submitWeightDecrease = findViewById(R.id.submitWeightDecreased);
        submitWeightDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (option != null) {
                    MainActivity.addAnswer("Weight (Decreased): "+option);
                    MainActivity.updateScore(Math.max(AppetiteChangeActivity.getPoints(), points));

                    Intent messageIntent = new Intent(getApplicationContext(), ConcentrationActivity.class);
                    /*messageIntent.putExtra("updatedScore", (currentScore + points));
                    messageIntent.putStringArrayListExtra("weightAnswers", weightAnswers);*/
                    startActivity(messageIntent);
                } else {
                    Toast.makeText(WeightDecreasedActivity.this,
                            (String) getString(R.string.questions_unanswered_message),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void actionClick(View rb) {
        RadioButton choice = findViewById(rb.getId());
        option = choice.getText().toString();

        if (rb.getId() == R.id.wtDec0) {
            points = 0;
            Log.d("Wt.Dec.0", "actionClick: "+option);
        } else if (rb.getId() == R.id.wtDec1) {
            points = 1;
            Log.d("Wt.Dec.1", "actionClick: "+option);
        } else if (rb.getId() == R.id.wtDec2) {
            points = 2;
            Log.d("Wt.Dec.2", "actionClick: "+option);
        } else if (rb.getId() == R.id.wtDec3) {
            points = 3;
            Log.d("Wt.Dec.3", "actionClick: "+option);
        }
    }
}