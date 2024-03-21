package com.example.lecture8_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class GuiltActivity extends AppCompatActivity {

    private String guiltOption;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guilt);

        Button submitGuilt = findViewById(R.id.submitGuilt);
        submitGuilt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guiltOption != null) {
                    MainActivity.addAnswer("Guilt: "+guiltOption);
                    MainActivity.updateScore(points);

                    Intent messageIntent = new Intent(getApplicationContext(), SuicidalIdeationActivity.class);
                    startActivity(messageIntent);
                } else {
                    Toast.makeText(GuiltActivity.this,
                            (String) getString(R.string.questions_unanswered_message),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void actionClick(View rb) {
        RadioButton choice = findViewById(rb.getId());
        guiltOption = choice.getText().toString();

        if (rb.getId() == R.id.guilt0) {
            points = 0;
            Log.d("Guilt.0", "actionClick: "+guiltOption);
        } else if (rb.getId() == R.id.guilt1) {
            points = 1;
            Log.d("Guilt.1", "actionClick: "+guiltOption);
        } else if (rb.getId() == R.id.guilt2) {
            points = 2;
            Log.d("Guilt.2", "actionClick: "+guiltOption);
        } else if (rb.getId() == R.id.guilt3) {
            points = 3;
            Log.d("Guilt.3", "actionClick: "+guiltOption);
        }
    }

}