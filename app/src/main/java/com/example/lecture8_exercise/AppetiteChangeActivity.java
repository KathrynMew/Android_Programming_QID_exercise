package com.example.lecture8_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class AppetiteChangeActivity extends AppCompatActivity {

    private static int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appetite_change);

        RadioButton inc = findViewById(R.id.appInc);
        RadioButton dec = findViewById(R.id.appDec);
        Button submitChange = findViewById(R.id.submitAppetiteChange);
        submitChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inc.isChecked()) {
                    Intent messageIntent = new Intent(getApplicationContext(), AppetiteIncreasedActivity.class);
                    startActivity(messageIntent);
                } else if (dec.isChecked()) {
                    Intent messageIntent = new Intent(getApplicationContext(), AppetiteDecreasedActivity.class);
                    startActivity(messageIntent);
                } else {
                    Toast.makeText(AppetiteChangeActivity.this,
                            (String) getString(R.string.questions_unanswered_message),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public static void setPoints(int p) {
        points = p;
    }

    public static int getPoints() {
        return points;
    }
}