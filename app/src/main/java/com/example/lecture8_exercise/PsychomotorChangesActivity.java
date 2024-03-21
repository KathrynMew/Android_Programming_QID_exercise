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

public class PsychomotorChangesActivity extends AppCompatActivity {

    private String psychSlowOption;
    private String psychAgitOption;

    private int slowPoints;
    private int agitPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychomotor_changes);

        /*Intent fatigueMessage = getIntent();
        int currentScore = fatigueMessage.getIntExtra("updatedScore", 0);
        ArrayList<String> psychoAnswers = fatigueMessage.getStringArrayListExtra("fatigueAnswers");*/

        Button submitPsychomotorChanges = findViewById(R.id.submitPsych);
        submitPsychomotorChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check all questions are answered
                if ((psychSlowOption != null) && (psychAgitOption != null)) {
                    // Psychomotor Changes calculation uses the highest score from Slowing and Agitation
                    MainActivity.updateScore(Math.max(slowPoints, agitPoints));

                    // Add responses to arraylist
                    MainActivity.addAnswer("Psychomotor Slowing: "+psychSlowOption);
                    MainActivity.addAnswer("Psychomotor Agitation: "+psychAgitOption);

                    Intent messageIntent = new Intent(getApplicationContext(), ReviewAnswersActivity.class);
                    startActivity(messageIntent);
                } else {
                    Toast.makeText(PsychomotorChangesActivity.this,
                            (String) getString(R.string.questions_unanswered_message),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void actionClickSlow(View rb) {
        RadioButton choice = findViewById(rb.getId());
        psychSlowOption = choice.getText().toString();

        if (rb.getId() == R.id.psySlow0) {
            slowPoints = 0;
            Log.d("psySlow.0", "actionClick: "+psychSlowOption);
        } else if (rb.getId() == R.id.psySlow1) {
            slowPoints = 1;
            Log.d("psySlow.1", "actionClick: "+psychSlowOption);
        } else if (rb.getId() == R.id.psySlow2) {
            slowPoints = 2;
            Log.d("psySlow.2", "actionClick: "+psychSlowOption);
        } else if (rb.getId() == R.id.psySlow3) {
            slowPoints = 3;
            Log.d("psySlow.3", "actionClick: "+psychSlowOption);
        }
    }

    public void actionClickAgit(View rb) {
        RadioButton choice = findViewById(rb.getId());
        psychAgitOption = choice.getText().toString();

        if (rb.getId() == R.id.psyAgit0) {
            agitPoints = 0;
            Log.d("Agitation.0", "actionClick: "+psychAgitOption);
        } else if (rb.getId() == R.id.psyAgit1) {
            agitPoints = 1;
            Log.d("Agitation.1", "actionClick: "+psychAgitOption);
        } else if (rb.getId() == R.id.psyAgit2) {
            agitPoints = 2;
            Log.d("Agitation.2", "actionClick: "+psychAgitOption);
        } else if (rb.getId() == R.id.psyAgit3) {
            agitPoints = 3;
            Log.d("Agitation.3", "actionClick: "+psychAgitOption);
        }
    }
}