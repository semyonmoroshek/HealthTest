package com.example.android.healthtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.healthtest.model.Question;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_yes) Button btnYes;
    @BindView(R.id.btn_sometms) Button btnSometimes;
    @BindView(R.id.btn_no) Button btnNo;
    @BindView(R.id.txt_question) TextView txtQuestion;
    @BindView(R.id.pb_progress) ProgressBar userProgressBar;

    private int mQuestionIndex = 0;
    private int yesAnswerCount = 0;
    private int noAnswerCount = 0;
    private int sometimesAnswerCount = 0;

    private Question[] questionCollection = new Question[]{
            new Question(R.string.q1),
            new Question(R.string.q2),
            new Question(R.string.q3),
            new Question(R.string.q4),
            new Question(R.string.q5)};

    int userProgresStep = (int) Math.ceil(100.0 / questionCollection.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        startTest();

        btnYes.setOnClickListener(View -> yesAnswer());
        btnSometimes.setOnClickListener(View -> sometimesAnswer());
        btnNo.setOnClickListener(View -> noAnswer());
    }

    private void startTest() {
        displayNewQuestion();
    }

    private void sometimesAnswer() {
        sometimesAnswerCount++;
        displayNewQuestion();
    }

    private void noAnswer() {
        noAnswerCount++;
        displayNewQuestion();
    }

    private void yesAnswer() {
        yesAnswerCount++;
        displayNewQuestion();
    }

    private void displayNewQuestion() {
        if(mQuestionIndex > 0){
            userProgressBar.incrementProgressBy(userProgresStep);
        }
        if (mQuestionIndex < questionCollection.length) {
            Question question = questionCollection[mQuestionIndex];
            int question1 = question.getQuestionNumber();
            txtQuestion.setText(question1);
            mQuestionIndex++;
        } else {
            resetApp();
        }
    }

    private void resetApp() {
        viewResult();
        mQuestionIndex = 0;
        userProgressBar.setProgress(0);
        displayNewQuestion();
    }

    private void viewResult() {
        if (yesAnswerCount > noAnswerCount && yesAnswerCount > sometimesAnswerCount) {
            Toast.makeText(this, "your result: " + "you will have bad health", Toast.LENGTH_LONG).show();
        }
        if (noAnswerCount > yesAnswerCount && noAnswerCount > sometimesAnswerCount) {
            Toast.makeText(this, "your result: " + "you will have good health", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "your result: " + "you have a normal health", Toast.LENGTH_LONG).show();
        }
    }
}
