package com.example.familiada.models;

import java.util.LinkedList;

public class Session {

    LinkedList<Question> questions;
    int[] points = new int[] {0, 0};

    public Session() {
        this.questions = new LinkedList<>();
    }


    public LinkedList<Question> getQuestions() {
        return questions;
    }

    public int getPoints(int team) {
        return points[team - 1];
    }

    public void addQuestion(String question, String[] answers, int[] points) {
        int number_of_answers = answers.length;
        LinkedList<Answer> a = new LinkedList<>();
        for (int i = 0; i < number_of_answers; ++i) {
            a.add(new Answer(answers[i], points[i]));
        }
        questions.add(new Question(question, number_of_answers, a));
    }
}
