package com.example.android.healthtest.entities;

import java.util.ArrayList;
import java.util.List;

public class Message {

    void message(){
        List<String> questionList = new ArrayList<>();
        String question1 = "Are you eat healthy food? ";
        String question2 = "Are you drink steal water more then 2 L/day? ";
        String question3 = "Are you sleep more then 7 our/night?";
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
    }

}
