package com.example.familiada.models;

public class ActiveQuestion {

    public Question getQuestion() {
        return question;
    }

    Question question;
    Session session;
    int question_no;
    int no_of_guessed;
    int sum;
    public boolean[] guessed;

    int incorrect_answers;
    int[] mult_coeffs = new int[] {1, 1, 1, 2, 3, 3, 3, 3};

    public ActiveQuestion(Question question, Session session, int question_no) {
        this.question = question;
        this.session = session;
        this.question_no = question_no;
        incorrect_answers = 0;
        guessed = new boolean[question.number_of_answers];
        no_of_guessed = 0;
    }

    public int getNo_of_guessed() {
        return no_of_guessed;
    }

    public int getIncorrect_answers() {
        return incorrect_answers;
    }

    public int getSum() {
        return sum;
    }

    public void guessOne(int number, int team) {
        if (guessed[number - 1]) return;
        guessed[number - 1] = true;
        sum += question.answers.get(number - 1).points;
        no_of_guessed++;
    }

    public void addToSum(int x) {
        sum += x;
    }

    public void guessWrong(int team) {
        incorrect_answers++;
    }

    public void end(int winner) {
        session.points[winner - 1] += sum * mult_coeffs[question_no];
    }
}
