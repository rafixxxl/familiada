package com.example.familiada;

import com.example.familiada.models.ActiveQuestion;
import com.example.familiada.models.Answer;
import com.example.familiada.models.GlobalVar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class FirstStageController {

    @FXML
    Stage stage;
    @FXML
    Parent root;

    public TextArea answer1, points1, number1;
    public TextArea answer2, points2, number2;
    public TextArea answer3, points3, number3;
    public TextArea answer4, points4, number4;
    public TextArea answer5, points5, number5;
    public TextArea answer6, points6, number6;
    public TextArea total_points;

    public Shape lbad1, lbad2, lbad3, lbigbad, rbad1, rbad2, rbad3, rbigbad;
    public TextArea total_points1, total_points2;
    public Button left_wins, right_wins;

    int[] mult_coeffs = new int[] {1, 1, 1, 2, 3, 3, 3, 3};
    String[] numerals = new String[] {"pierwsza", "druga", "trzecia", "czwarta", "piąta", "szósta", "siódma", "ósma"};
    boolean end_of_round_pressed = false;
    boolean lbad1_pressed, lbad2_pressed, lbad3_pressed, lbigbad_pressed, rbad1_pressed, rbad2_pressed, rbad3_pressed, rbigbad_pressed;

    @FXML
    public void initialize() {
        playSound("start_round.wav");
        end_of_round_pressed = false;
        lbad1_pressed = lbad2_pressed = lbad3_pressed = lbigbad_pressed = false;
        rbad1_pressed = rbad2_pressed = rbad3_pressed = rbigbad_pressed = false;
        total_points1.setText(Integer.toString(GlobalVar.current_session.getPoints(1)));
        System.out.println(GlobalVar.current_session.getPoints(1));
        total_points2.setText(Integer.toString(GlobalVar.current_session.getPoints(2)));

        // hiding unnecessary elements
        if (GlobalVar.current_active_question.getQuestion().getNumber_of_answers() < 6) {
            answer6.setVisible(false);
            points6.setVisible(false);
            number6.setVisible(false);
        }
        if (GlobalVar.current_active_question.getQuestion().getNumber_of_answers() < 5) {
            answer5.setVisible(false);
            points5.setVisible(false);
            number5.setVisible(false);
        }
        if (GlobalVar.current_active_question.getQuestion().getNumber_of_answers() < 4) {
            answer4.setVisible(false);
            points4.setVisible(false);
            number4.setVisible(false);
        }
        if (GlobalVar.current_active_question.getQuestion().getNumber_of_answers() < 3) {
            answer3.setVisible(false);
            points3.setVisible(false);
            number3.setVisible(false);
        }
    }

    @FXML
    public void RevealFirstAnswer() {
        if (GlobalVar.current_active_question.guessed[0]) return;
        GlobalVar.current_active_question.guessed[0] = true;
        System.out.println("Revealing first answer");
        Answer guessed_answer = GlobalVar.current_session.getQuestions().get(GlobalVar.current_round - 1).getAnswers().get(0);
        answer1.setText(guessed_answer.getAnswer());
        points1.setText(Integer.toString(guessed_answer.getPoints()));
        if (!end_of_round_pressed) {
            GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
            total_points.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        }
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
        if (!end_of_round_pressed) {
            GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
            total_points.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        }
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
        if (!end_of_round_pressed) {
            GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
            total_points.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        }
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
        if (!end_of_round_pressed) {
            GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
            total_points.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        }
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
        if (!end_of_round_pressed) {
            GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
            total_points.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        }
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
        if (!end_of_round_pressed) {
            GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
            total_points.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        }
        playSound("correct.wav");
    }

    @FXML
    public void BigBadLeft() {
        if (!lbigbad_pressed) {
            playSound("incorrect.wav");
            lbigbad.setFill(Paint.valueOf("FFFF00"));
            lbigbad_pressed = true;
        } else {
            lbigbad.setFill(Paint.valueOf("111111"));
            lbigbad_pressed = false;
        }
    }

    @FXML
    public void SmallBadLeft1() {
        if (!lbad1_pressed) {
            playSound("incorrect.wav");
            lbad1.setFill(Paint.valueOf("FFFF00"));
            lbad1_pressed = true;
        } else {
            lbad1.setFill(Paint.valueOf("111111"));
            lbad1_pressed = false;
        }
    }

    @FXML
    public void SmallBadLeft2() {
        if (!lbad2_pressed) {
            playSound("incorrect.wav");
            lbad2.setFill(Paint.valueOf("FFFF00"));
            lbad2_pressed = true;
        } else {
            lbad2.setFill(Paint.valueOf("111111"));
            lbad2_pressed = false;
        }
    }

    @FXML
    public void SmallBadLeft3() {
        if (!lbad3_pressed) {
            playSound("incorrect.wav");
            lbad3.setFill(Paint.valueOf("FFFF00"));
            lbad3_pressed = true;
        } else {
            lbad3.setFill(Paint.valueOf("111111"));
            lbad3_pressed = false;
        }
    }

    @FXML
    public void BigBadRight() {
        if (!rbigbad_pressed) {
            playSound("incorrect.wav");
            rbigbad.setFill(Paint.valueOf("FFFF00"));
            rbigbad_pressed = true;
        } else {
            rbigbad.setFill(Paint.valueOf("111111"));
            rbigbad_pressed = false;
        }
    }

    @FXML
    public void SmallBadRight1() {
        if (!rbad1_pressed) {
            playSound("incorrect.wav");
            rbad1.setFill(Paint.valueOf("FFFF00"));
            rbad1_pressed = true;
        } else {
            rbad1.setFill(Paint.valueOf("111111"));
            rbad1_pressed = false;
        }
    }

    @FXML
    public void SmallBadRight2() {
        if (!rbad2_pressed) {
            playSound("incorrect.wav");
            rbad2.setFill(Paint.valueOf("FFFF00"));
            rbad2_pressed = true;
        } else {
            rbad2.setFill(Paint.valueOf("111111"));
            rbad2_pressed = false;
        }
    }

    @FXML
    public void SmallBadRight3() {
        if (!rbad3_pressed) {
            playSound("incorrect.wav");
            rbad3.setFill(Paint.valueOf("FFFF00"));
            rbad3_pressed = true;
        } else {
            rbad3.setFill(Paint.valueOf("111111"));
            rbad3_pressed = false;
        }
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

    @FXML
    public void GoToNextRoundLeft() {
        if (end_of_round_pressed) return;
        System.out.println("Left wins!");
        playSound("clapping.wav");
        GlobalVar.current_session.addPoints(1, GlobalVar.current_active_question.getSum() * mult_coeffs[GlobalVar.current_round - 1]);
        total_points1.setText(Integer.toString(GlobalVar.current_session.getPoints(1)));
        end_of_round_pressed = true;
    }

    @FXML
    public void GoToNextRoundRight() {
        if (end_of_round_pressed) return;
        System.out.println("Right wins!");
        playSound("clapping.wav");
        GlobalVar.current_session.addPoints(2, GlobalVar.current_active_question.getSum() * mult_coeffs[GlobalVar.current_round - 1]);
        total_points2.setText(Integer.toString(GlobalVar.current_session.getPoints(2)));
        end_of_round_pressed = true;
    }

    @FXML
    private void GoToNextRound(ActionEvent event) throws IOException {
        if (GlobalVar.current_session.getPoints(1) >= 300 || GlobalVar.current_session.getPoints(2) >= 300) {
            System.out.println("To the final!");
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();  // TODO: przejście do rundy finałowej
            return;
        }
        System.out.println("New round!");
        GlobalVar.current_active_question = new ActiveQuestion(GlobalVar.current_session.getQuestions().get(GlobalVar.current_round),
                GlobalVar.current_session, GlobalVar.current_round + 1);
        GlobalVar.current_round++;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("firststage-view.fxml"));
        root = loader.load();
        GlobalVar.mainStage.close();
        GlobalVar.mainStage.setScene(new Scene(root));
        GlobalVar.mainStage.setTitle("Runda " + numerals[GlobalVar.current_round - 1]);
        GlobalVar.mainStage.show();
    }

    public static void playSound(String name) {
        InputStream is = FirstStageController.class.getClassLoader().getResourceAsStream(name);
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