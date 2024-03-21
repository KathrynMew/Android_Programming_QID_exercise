/**
 * Author: Kathryn Mew
 * Assignment: Lab 2
 **/
package com.example.lecture8_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static ArrayList<String> answers = new ArrayList<>();
    private static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText user = findViewById(R.id.editUsername);

        Button begin = findViewById(R.id.beginButton);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user.getText().toString();
                Intent messageIntent = new Intent(getApplicationContext(), SleepActivity.class);
                startActivity(messageIntent);
            }
        });
    }

    public static void updateScore(int p) {
       score += p;
    }

    public static int getScore() {
        return score;
    }

    public static void addAnswer(String a) {
        answers.add(a);
    }

    public static String getResponses() {
        String responsesInput = "";
        if (answers != null) {
            for (String res : answers) {
                responsesInput += (res + "\n");
                Log.d("Review", "====="+res);
            }

            return responsesInput;
        }

        return "";
    }
}