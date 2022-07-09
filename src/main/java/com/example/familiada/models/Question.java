package com.example.familiada.models;

import java.util.LinkedList;

public class Question {

    public Question(String question, int number_of_answers, LinkedList<Answer> answers) {
        this.question = question;
        this.number_of_answers = number_of_answers;
        this.answers = answers;
    }

    String question;
    int number_of_answers;
    LinkedList<Answer> answers;
}