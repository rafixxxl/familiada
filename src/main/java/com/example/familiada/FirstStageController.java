package com.example.familiada;

import com.example.familiada.models.ActiveQuestion;
import com.example.familiada.models.Answer;
import com.example.familiada.models.GlobalVar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class FirstStageController {

    @FXML
    Stage stage;
    @FXML
    Parent root;

    public Text ans1, ans2, ans3, ans4, ans5, ans6;
    public Text no1, no2, no3, no4, no5, no6;
    public Text pts1, pts2, pts3, pts4, pts5, pts6;
    public Text total_pts, total_pts1, total_pts2;
    public ImageView lb1, lb2, lb3, rb1, rb2, rb3, lb, rb;
    public Button left_wins, right_wins;

    int[] mult_coeffs = new int[] {1, 1, 1, 2, 3, 3, 3, 3};
    String[] numerals = new String[] {"pierwsza", "druga", "trzecia", "czwarta", "piąta", "szósta", "siódma", "ósma"};
    boolean end_of_round_pressed = false;
    boolean lbad1_pressed, lbad2_pressed, lbad3_pressed, lbigbad_pressed, rbad1_pressed, rbad2_pressed, rbad3_pressed, rbigbad_pressed;

    @FXML
    public void initialize() {
        if (GlobalVar.current_round != 1) playSound("start_round.wav");
        // else playSound("intro.wav"); // odkomentuj jak cie przestanie wkurzac
        end_of_round_pressed = false;
        lbad1_pressed = lbad2_pressed = lbad3_pressed = lbigbad_pressed = false;
        rbad1_pressed = rbad2_pressed = rbad3_pressed = rbigbad_pressed = false;
        total_pts1.setText(Integer.toString(GlobalVar.current_session.getPoints(1)));
        System.out.println(GlobalVar.current_session.getPoints(1));
        total_pts2.setText(Integer.toString(GlobalVar.current_session.getPoints(2)));

        // hiding unnecessary elements
        if (GlobalVar.current_active_question.getQuestion().getNumber_of_answers() < 6) {
            ans6.setVisible(false);
            pts6.setVisible(false);
            no6.setVisible(false);
        }
        if (GlobalVar.current_active_question.getQuestion().getNumber_of_answers() < 5) {
            ans5.setVisible(false);
            pts5.setVisible(false);
            no5.setVisible(false);
        }
        if (GlobalVar.current_active_question.getQuestion().getNumber_of_answers() < 4) {
            ans4.setVisible(false);
            pts4.setVisible(false);
            no4.setVisible(false);
        }
        if (GlobalVar.current_active_question.getQuestion().getNumber_of_answers() < 3) {
            ans3.setVisible(false);
            pts3.setVisible(false);
            no3.setVisible(false);
        }
        lb.setVisible(false);
        lb1.setVisible(false);
        lb2.setVisible(false);
        lb3.setVisible(false);
        rb.setVisible(false);
        rb1.setVisible(false);
        rb2.setVisible(false);
        rb3.setVisible(false);
    }

    @FXML
    public void RevealFirstAnswer() {
        if (GlobalVar.current_active_question.guessed[0]) return;
        GlobalVar.current_active_question.guessed[0] = true;
        System.out.println("Revealing first answer");
        Answer guessed_answer = GlobalVar.current_session.getQuestions().get(GlobalVar.current_round - 1).getAnswers().get(0);
        ans1.setText(guessed_answer.getAnswer());
        pts1.setText(Integer.toString(guessed_answer.getPoints()));
        if (!end_of_round_pressed) {
            GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
            total_pts.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        }
        playSound("correct.wav");
    }

    @FXML
    public void RevealSecondAnswer() {
        if (GlobalVar.current_active_question.guessed[1]) return;
        GlobalVar.current_active_question.guessed[1] = true;
        System.out.println("Revealing second answer");
        Answer guessed_answer = GlobalVar.current_session.getQuestions().get(GlobalVar.current_round - 1).getAnswers().get(1);
        ans2.setText(guessed_answer.getAnswer());
        pts2.setText(Integer.toString(guessed_answer.getPoints()));
        if (!end_of_round_pressed) {
            GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
            total_pts.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        }
        playSound("correct.wav");
    }

    @FXML
    public void RevealThirdAnswer() {
        if (GlobalVar.current_active_question.guessed[2]) return;
        GlobalVar.current_active_question.guessed[2] = true;
        System.out.println("Revealing third answer");
        Answer guessed_answer = GlobalVar.current_session.getQuestions().get(GlobalVar.current_round - 1).getAnswers().get(2);
        ans3.setText(guessed_answer.getAnswer());
        pts3.setText(Integer.toString(guessed_answer.getPoints()));
        if (!end_of_round_pressed) {
            GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
            total_pts.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
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
        ans4.setText(guessed_answer.getAnswer());
        pts4.setText(Integer.toString(guessed_answer.getPoints()));
        if (!end_of_round_pressed) {
            GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
            total_pts.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
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
        ans5.setText(guessed_answer.getAnswer());
        pts5.setText(Integer.toString(guessed_answer.getPoints()));
        if (!end_of_round_pressed) {
            GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
            total_pts.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
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
        ans6.setText(guessed_answer.getAnswer());
        pts6.setText(Integer.toString(guessed_answer.getPoints()));
        if (!end_of_round_pressed) {
            GlobalVar.current_active_question.addToSum(guessed_answer.getPoints());
            total_pts.setText(Integer.toString(GlobalVar.current_active_question.getSum()));
        }
        playSound("correct.wav");
    }

    @FXML
    public void BigBadLeft() {
        if (!lbigbad_pressed) {
            playSound("incorrect.wav");
            lb.setVisible(true);
            lbigbad_pressed = true;
        } else {
            lb.setVisible(false);
            lbigbad_pressed = false;
        }
    }

    @FXML
    public void SmallBadLeft1() {
        if (!lbad1_pressed) {
            playSound("incorrect.wav");
            lb1.setVisible(true);
            lbad1_pressed = true;
        } else {
            lb1.setVisible(false);
            lbad1_pressed = false;
        }
    }

    @FXML
    public void SmallBadLeft2() {
        if (!lbad2_pressed) {
            playSound("incorrect.wav");
            lb2.setVisible(true);
            lbad2_pressed = true;
        } else {
            lb2.setVisible(false);
            lbad2_pressed = false;
        }
    }

    @FXML
    public void SmallBadLeft3() {
        if (!lbad3_pressed) {
            playSound("incorrect.wav");
            lb3.setVisible(true);
            lbad3_pressed = true;
        } else {
            lb3.setVisible(false);
            lbad3_pressed = false;
        }
    }

    @FXML
    public void BigBadRight() {
        if (!rbigbad_pressed) {
            playSound("incorrect.wav");
            rb.setVisible(true);
            rbigbad_pressed = true;
        } else {
            rb.setVisible(false);
            rbigbad_pressed = false;
        }
    }

    @FXML
    public void SmallBadRight1() {
        if (!rbad1_pressed) {
            playSound("incorrect.wav");
            rb1.setVisible(true);
            rbad1_pressed = true;
        } else {
            rb1.setVisible(false);
            rbad1_pressed = false;
        }
    }

    @FXML
    public void SmallBadRight2() {
        if (!rbad2_pressed) {
            playSound("incorrect.wav");
            rb2.setVisible(true);
            rbad2_pressed = true;
        } else {
            rb2.setVisible(false);
            rbad2_pressed = false;
        }
    }

    @FXML
    public void SmallBadRight3() {
        if (!rbad3_pressed) {
            playSound("incorrect.wav");
            rb3.setVisible(true);
            rbad3_pressed = true;
        } else {
            rb3.setVisible(false);
            rbad3_pressed = false;
        }
    }

    @FXML
    private void keyPressed(KeyEvent keyEvent) throws IOException {
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
        } else if (k == KeyCode.Q) {
            SmallBadLeft1();
        } else if (k == KeyCode.A) {
            SmallBadLeft2();
        } else if (k == KeyCode.Z) {
            SmallBadLeft3();
        } else if (k == KeyCode.S) {
            BigBadLeft();
        } else if (k == KeyCode.P) {
            SmallBadRight1();
        } else if (k == KeyCode.L) {
            SmallBadRight2();
        } else if (k == KeyCode.M || k == KeyCode.COMMA) {
            SmallBadRight3();
        } else if (k == KeyCode.K) {
            BigBadRight();
        } else if (k == KeyCode.J) {
            playSound("joke1.wav");
        } else if (k == KeyCode.V) {
            GoToNextRoundLeft();
        } else if (k == KeyCode.N) {
            GoToNextRoundRight();
        } else if (k == KeyCode.B || k == KeyCode.SPACE) {
            GoToNextRound();
        }
    }

    @FXML
    public void GoToNextRoundLeft() {
        if (end_of_round_pressed) return;
        System.out.println("Left wins!");
        playSound("clapping.wav");
        GlobalVar.current_session.addPoints(1, GlobalVar.current_active_question.getSum() * mult_coeffs[GlobalVar.current_round - 1]);
        total_pts1.setText(Integer.toString(GlobalVar.current_session.getPoints(1)));
        end_of_round_pressed = true;
    }

    @FXML
    public void GoToNextRoundRight() {
        if (end_of_round_pressed) return;
        System.out.println("Right wins!");
        playSound("clapping.wav");
        GlobalVar.current_session.addPoints(2, GlobalVar.current_active_question.getSum() * mult_coeffs[GlobalVar.current_round - 1]);
        total_pts2.setText(Integer.toString(GlobalVar.current_session.getPoints(2)));
        end_of_round_pressed = true;
    }

    @FXML
    private void GoToNextRound() throws IOException {
        if (!end_of_round_pressed) return;
        if (GlobalVar.current_session.getPoints(1) >= 300 || GlobalVar.current_session.getPoints(2) >= 300) {
            System.out.println("To the final!");
            stage = GlobalVar.mainStage;
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
        Scene scene = new Scene(root);
        GlobalVar.mainStage.setScene(scene);
        GlobalVar.currentScene = scene;
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