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

public class SleepActivity extends AppCompatActivity {

    private String onsetOption;
    private String midNocOption;
    private String mornOption;
    private String hyperOption;

    private int onsetPoints;
    private int midNocPoints;
    private int mornPoints;
    private int hyperPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        /*Intent mainMessage = getIntent();
        int currentScore = mainMessage.getIntExtra("currentScore", 0);
        ArrayList<String> currentAnswers = mainMessage.getStringArrayListExtra("surveyAnswers");*/

        Button submitSleep = findViewById(R.id.submitSleep);
        submitSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((onsetOption != null) && (midNocOption != null) &&
                        (mornOption != null) && (hyperOption != null)) {

                    // takes the highest score from all sleep questions
                    MainActivity.updateScore(Math.max(onsetPoints,
                            Math.max(midNocPoints, Math.max(mornPoints, hyperPoints))));

                    MainActivity.addAnswer("Sleep Onset Insomnia: "+onsetOption);
                    MainActivity.addAnswer("Mid-nocturnal Insomnia: "+midNocOption);
                    MainActivity.addAnswer("Early Morning Insomnia: "+mornOption);
                    MainActivity.addAnswer("Hypersomnia: "+hyperOption);

                    Intent messageIntent = new Intent(getApplicationContext(), MoodActivity.class);
                    startActivity(messageIntent);
                } else {
                    Toast.makeText(SleepActivity.this,
                            (String) getString(R.string.questions_unanswered_message),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // Sleep Onset Insomnia
    public void onClickOnset(View rb1) {
        RadioButton choice = findViewById(rb1.getId());
        onsetOption = choice.getText().toString();

        if (rb1.getId() == R.id.onset0) {
            onsetPoints = 0;
            Log.d("Onset.0", "actionClick: "+onsetOption);
        } else if (rb1.getId() == R.id.onset1) {
            onsetPoints = 1;
            Log.d("Onset.1", "actionClick: "+onsetOption);
        } else if (rb1.getId() == R.id.onset2) {
            onsetPoints = 2;
            Log.d("Onset.2", "actionClick: "+onsetOption);
        } else if (rb1.getId() == R.id.onset3) {
            onsetPoints = 3;
            Log.d("Onset.3", "actionClick: "+onsetOption);
        }
    }

    public void onClickMidNoc(View rb2) {
        RadioButton choice = findViewById(rb2.getId());
        midNocOption = choice.getText().toString();

        if (rb2.getId() == R.id.midNoc0) {
            midNocPoints = 0;
            Log.d("midNoc.0", "actionClick: "+midNocOption);
        } else if (rb2.getId() == R.id.midNoc1) {
            midNocPoints = 1;
            Log.d("midNoc.1", "actionClick: "+midNocOption);
        } else if (rb2.getId() == R.id.midNoc2) {
            midNocPoints = 2;
            Log.d("midNoc.2", "actionClick: "+midNocOption);
        } else if (rb2.getId() == R.id.midNoc3) {
            midNocPoints = 3;
            Log.d("midNoc.3", "actionClick: "+midNocOption);
        }
    }

    public void onClickMorn(View rb3) {
        RadioButton choice = findViewById(rb3.getId());
        mornOption = choice.getText().toString();

        if (rb3.getId() == R.id.earlyMorn0) {
            mornPoints = 0;
            Log.d("morn.0", "actionClick: "+mornOption);
        } else if (rb3.getId() == R.id.earlyMorn1) {
            mornPoints = 1;
            Log.d("morn.1", "actionClick: "+mornOption);
        } else if (rb3.getId() == R.id.earlyMorn2) {
            mornPoints = 2;
            Log.d("morn.2", "actionClick: "+mornOption);
        } else if (rb3.getId() == R.id.earlyMorn3) {
            mornPoints = 3;
            Log.d("morn.3", "actionClick: "+mornOption);
        }
    }

    public void onClickHyper(View rb4) {
        RadioButton choice = findViewById(rb4.getId());
        hyperOption = choice.getText().toString();

        if (rb4.getId() == R.id.hyper0) {
            hyperPoints = 0;
            Log.d("hyper.0", "actionClick: "+hyperOption);
        } else if (rb4.getId() == R.id.hyper1) {
            hyperPoints = 1;
            Log.d("hyper.1", "actionClick: "+hyperOption);
        } else if (rb4.getId() == R.id.hyper2) {
            hyperPoints = 2;
            Log.d("hyper.2", "actionClick: "+hyperOption);
        } else if (rb4.getId() == R.id.hyper3) {
            hyperPoints = 3;
            Log.d("hyper.3", "actionClick: "+hyperOption);
        }
    }

}