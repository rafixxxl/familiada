package com.example.familiada;

import com.example.familiada.models.Answer;
import com.example.familiada.models.GlobalVar;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class FirstStageController {

    public Button next_round_button;
    public TextArea answer1, points1;
    public TextArea answer2, points2;
    public TextArea answer3, points3;
    public TextArea answer4, points4;
    public TextArea answer5, points5;
    public TextArea answer6, points6;
    public TextArea total_points;

    @FXML
    public void GoToNextRound() {
        System.out.println("New round!");
    }

    @FXML
    public void RevealFirstAnswer() {
        if (GlobalVar.current_active_question.guessed[0]) return;
        GlobalVar.current_active_question.guessed[0] = true;
        System.out.println("Revealing first answer");
        Answer guessed_answer = GlobalVar.current_session.getQuestions().get(GlobalVar.current_round - 1).getAnswers().get(0);
        answer1.setText(guessed_answer.getAnswer());
        points1.setText(Integer.toString(guessed_answer.getPoints()));
        GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
        total_points.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        playSound("correct.wav");
    }

    @FXML
    public void RevealSecondAnswer() {
        if (GlobalVar.current_active_question.guessed[1]) return;
        GlobalVar.current_active_question.guessed[1] = true;
        System.out.println("Revealing second answer");
        Answer guessed_answer = GlobalVar.current_session.getQuestions().get(GlobalVar.current_round - 1).getAnswers().get(1);
        answer2.setText(guessed_answer.getAnswer());
        points2.setText(Integer.toString(guessed_answer.getPoints()));
        GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
        total_points.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        playSound("correct.wav");
    }

    @FXML
    public void RevealThirdAnswer() {
        if (GlobalVar.current_active_question.guessed[2]) return;
        GlobalVar.current_active_question.guessed[2] = true;
        System.out.println("Revealing third answer");
        Answer guessed_answer = GlobalVar.current_session.getQuestions().get(GlobalVar.current_round - 1).getAnswers().get(2);
        answer3.setText(guessed_answer.getAnswer());
        points3.setText(Integer.toString(guessed_answer.getPoints()));
        GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
        total_points.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        playSound("correct.wav");
    }

    @FXML
    public void RevealFourthAnswer() {
        if (GlobalVar.current_session.getQuestions().get(GlobalVar.current_round - 1).getNumber_of_answers() < 4) return;
        if (GlobalVar.current_active_question.guessed[3]) return;
        GlobalVar.current_active_question.guessed[3] = true;
        System.out.println("Revealing fourth answer");
        Answer guessed_answer = GlobalVar.current_session.getQuestions().get(GlobalVar.current_round - 1).getAnswers().get(3);
        answer4.setText(guessed_answer.getAnswer());
        points4.setText(Integer.toString(guessed_answer.getPoints()));
        GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
        total_points.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        playSound("correct.wav");
    }

    @FXML
    public void RevealFifthAnswer() {
        if (GlobalVar.current_session.getQuestions().get(GlobalVar.current_round - 1).getNumber_of_answers() < 5) return;
        if (GlobalVar.current_active_question.guessed[4]) return;
        GlobalVar.current_active_question.guessed[4] = true;
        System.out.println("Revealing fifth answer");
        Answer guessed_answer = GlobalVar.current_session.getQuestions().get(GlobalVar.current_round - 1).getAnswers().get(4);
        answer5.setText(guessed_answer.getAnswer());
        points5.setText(Integer.toString(guessed_answer.getPoints()));
        GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
        total_points.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        playSound("correct.wav");
    }

    @FXML
    public void RevealSixthAnswer() {
        if (GlobalVar.current_session.getQuestions().get(GlobalVar.current_round - 1).getNumber_of_answers() < 6) return;
        if (GlobalVar.current_active_question.guessed[5]) return;
        GlobalVar.current_active_question.guessed[5] = true;
        System.out.println("Revealing sixth answer");
        Answer guessed_answer = GlobalVar.current_session.getQuestions().get(GlobalVar.current_round - 1).getAnswers().get(5);
        answer6.setText(guessed_answer.getAnswer());
        points6.setText(Integer.toString(guessed_answer.getPoints()));
        GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
        total_points.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        playSound("correct.wav");
    }

    @FXML
    private void keyPressed(KeyEvent keyEvent) {
        KeyCode k = keyEvent.getCode();
        if (k == KeyCode.DIGIT1) {
            RevealFirstAnswer();
        } else if (k == KeyCode.DIGIT2) {
            RevealSecondAnswer();
        } else if (k == KeyCode.DIGIT3) {
            RevealThirdAnswer();
        } else if (k == KeyCode.DIGIT4) {
            RevealFourthAnswer();
        } else if (k == KeyCode.DIGIT5) {
            RevealFifthAnswer();
        } else if (k == KeyCode.DIGIT6) {
            RevealSixthAnswer();
        }
    }

    private void playSound(String name) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(name);
        try {
            assert is != null;
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}