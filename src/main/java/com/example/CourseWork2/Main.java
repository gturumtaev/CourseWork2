package com.example.CourseWork2;

import com.example.CourseWork2.entity.Question;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Set<Question> questions = new HashSet<>();
        questions.add(new Question("Год распада СССР?", "1991"));
        questions.add(new Question("Год анексии Крыма?", "2014"));
        questions.add(new Question("Год начала войны?", "2022"));
        questions.add(new Question("Год конца Путина?", "????"));

        System.out.println(questions);


    }
}
