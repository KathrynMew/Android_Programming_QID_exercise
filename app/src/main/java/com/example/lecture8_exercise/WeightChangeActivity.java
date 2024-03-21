package com.example.lecture8_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class WeightChangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_change);

        // No "onClick" action needed
        RadioButton inc = findViewById(R.id.wtInc);
        RadioButton dec = findViewById(R.id.wtDec);

        Button submitChange = findViewById(R.id.submitWeight);
        submitChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inc.isChecked()) {
                    Intent messageIntent = new Intent(getApplicationContext(), WeightIncreasedActivity.class);
                    startActivity(messageIntent);
                } else if (dec.isChecked()) {
                    Intent messageIntent = new Intent(getApplicationContext(), WeightDecreasedActivity.class);
                    startActivity(messageIntent);
                } else {
                    Toast.makeText(WeightChangeActivity.this,
                            (String) getString(R.string.questions_unanswered_message),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}