package com.example.familiada.models;

public class Answer {
    String answer;
    int points;

    public Answer(String answer, int points) {
        this.answer = answer;
        this.points = points;
    }

    public String getAnswer() {
        return answer;
    }

    public int getPoints() {
        return points;
    }
}
