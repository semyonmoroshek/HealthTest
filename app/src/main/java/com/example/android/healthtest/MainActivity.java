package com.example.android.healthtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.healthtest.entities.Question;

public class MainActivity extends AppCompatActivity {

    int healthLevel = 0;
    int buttonClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayCheckHealth("Check health");
    }

    public void startPush(View view) {
        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setVisibility(View.INVISIBLE);
        buttonClicked++;
        displayNewQuestion();
    }

    public void displayNewQuestion() {
        Question question = new Question();
        TextView textDisplayQuestion = (TextView) findViewById(R.id.displayMessage);
        if (buttonClicked == 1) {
            textDisplayQuestion.setText(question.question1);
        }
        if (buttonClicked == 2) {
            textDisplayQuestion.setText(question.question2);
        }
        if (buttonClicked == 3) {
            textDisplayQuestion.setText(question.question3);
        }
        if (buttonClicked > 3) {
            Button startButton = (Button) findViewById(R.id.startButton);
            startButton.setVisibility(View.VISIBLE);
            displayResult();
            healthLevel = 0;
            buttonClicked = 0;
        }
    }

    public void displayResult() {
        if (healthLevel <= 1) {
            displayQuestion("You have a bad health");
        }
        if (healthLevel == 2) {
            displayQuestion("You have a normal health");
        }
        if (healthLevel == 3) {
            displayQuestion("You have a good health");
        }
    }

    public void displayTitle(String text) {
        TextView t = (TextView) findViewById(R.id.displayTitle);
        t.setText(text);
    }

    public void displayQuestion(String text) {
        TextView t = (TextView) findViewById(R.id.displayMessage);
        t.setText(text);
    }

    public void displayCheckHealth(String text) {
        displayTitle(text);
    }

    public void yes(View view) {
        if (buttonClicked > 0 && buttonClicked <= 3) {
            buttonClicked++;
            healthLevel++;
            displayNewQuestion();
        }
        if(buttonClicked > 3){
            displayResult();
        }
    }

    public void sometimes(View view) {
        if (buttonClicked > 0 && buttonClicked <= 3) {
            buttonClicked++;
            displayNewQuestion();
        }
        if(buttonClicked > 3){
            displayResult();
        }
    }

    public void no(View view) {
        if (buttonClicked > 0 && buttonClicked <= 3) {
            buttonClicked++;
            if(healthLevel > 0) {
                healthLevel--;
            }
            displayNewQuestion();
        }
        if(buttonClicked > 3){
            displayResult();
        }
    }
}

