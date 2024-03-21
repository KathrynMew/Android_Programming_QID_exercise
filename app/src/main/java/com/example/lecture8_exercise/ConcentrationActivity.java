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

public class ConcentrationActivity extends AppCompatActivity {
    private String option;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concentration);

        Button submitConcen = findViewById(R.id.submitConcen);
        submitConcen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (option != null) {
                    MainActivity.addAnswer("Concentration: "+option);
                    MainActivity.updateScore(points);

                    Intent messageIntent = new Intent(getApplicationContext(), GuiltActivity.class);
                    startActivity(messageIntent);
                } else {
                    Toast.makeText(ConcentrationActivity.this,
                            (String) getString(R.string.questions_unanswered_message),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void actionClick(View rb) {
        RadioButton choice = findViewById(rb.getId());
        option = choice.getText().toString();

        if (rb.getId() == R.id.concen0) {
            points = 0;
            Log.d("Concen.0", "actionClick: "+option);
        } else if (rb.getId() == R.id.concen1) {
            points = 1;
            Log.d("Concen.1", "actionClick: "+option);
        } else if (rb.getId() == R.id.concen2) {
            points = 2;
            Log.d("Concen.2", "actionClick: "+option);
        } else if (rb.getId() == R.id.concen3) {
            points = 3;
            Log.d("Concen.3", "actionClick: "+option);
        }
    }

}