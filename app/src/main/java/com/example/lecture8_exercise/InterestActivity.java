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

public class InterestActivity extends AppCompatActivity {

    private String option;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        Button submitInt = findViewById(R.id.submitInterest);
        submitInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (option != null) {
                    MainActivity.addAnswer("Interest: "+option);
                    MainActivity.updateScore(points);

                    Intent messageIntent = new Intent(getApplicationContext(), FatigueActivity.class);
                    startActivity(messageIntent);
                } else {
                    Toast.makeText(InterestActivity.this,
                            (String) getString(R.string.questions_unanswered_message),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void actionClick(View rb) {
        RadioButton choice = findViewById(rb.getId());
        option = choice.getText().toString();

        if (rb.getId() == R.id.int0) {
            points = 0;
            Log.d("Interest.0", "actionClick: "+option);
        } else if (rb.getId() == R.id.int1) {
            points = 1;
            Log.d("Interest.1", "actionClick: "+option);
        } else if (rb.getId() == R.id.int2) {
            points = 2;
            Log.d("Interest.2", "actionClick: "+option);
        } else if (rb.getId() == R.id.int3) {
            points = 3;
            Log.d("Interest.3", "actionClick: "+option);
        }
    }
}