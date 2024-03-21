package com.example.lecture8_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ReviewAnswersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_answers);

        // To review answers to all questions
        TextView reviewText = findViewById(R.id.inputText);
        TextView scoreText = findViewById(R.id.finalScore);

        String finalScoreInput = "final score: "+MainActivity.getScore();

        reviewText.setText(MainActivity.getResponses());
        scoreText.setText(finalScoreInput);

        // Button to return to MainActivity/User screen
        Button returnToMenu = findViewById(R.id.exitButton);
        returnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent messageIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(messageIntent);
            }
        });
    }
}