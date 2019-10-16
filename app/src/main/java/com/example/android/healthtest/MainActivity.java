package com.example.android.healthtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int healthLevel = 0;
    int buttonClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayCheckHealth("Check health");
    }

    public void displayTitle(String text) {
        TextView t = (TextView) findViewById(R.id.displayTitle);
        t.setText(text);
    }

    public void displayQuestion(String text) {
        TextView t = (TextView) findViewById(R.id.displayQuestions);
        t.setText(text);
    }

//    public void displayHealthPoint(int text) {
//        TextView t = (TextView) findViewById(R.id.displayMessage);
//        t.setText(text + "");
//    }

    public void displayCheckHealth(String text) {
        displayTitle(text);
    }

    public void yes(View view) {
        buttonClicked++;
        healthLevel++;
        pushButton();
    }

    public void sometimes(View view) {
        buttonClicked++;
        pushButton();
    }

    public void no(View view) {
        buttonClicked++;
        healthLevel--;
        pushButton();
    }

    public void pushButton(){
        if(buttonClicked == 1){
            displayQuestion("Are you eat healthy food? ");
        }
        if(buttonClicked == 2){
            displayQuestion("Are you drink steal water more then 2 l/day ");
        }
        if(buttonClicked > 2){
            displayResult();
        }

    }

    public void displayResult() {
        if(healthLevel < 2){
            displayQuestion("You have a bad health");
        }
        if(healthLevel == 2){
            displayQuestion("You have a normal health");
        }
        if(healthLevel >2){
            displayQuestion("You have a good health");
        }
    }


    public void start(View view) {
        Button t = (Button) findViewById(R.id.startButton);
        t.setVisibility(View.INVISIBLE);
        displayQuestion("Are you sleep more then 7 our/night?");

    }
}

