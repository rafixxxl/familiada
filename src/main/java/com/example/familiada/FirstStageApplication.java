package com.example.familiada;

import com.example.familiada.models.ActiveQuestion;
import com.example.familiada.models.GlobalVar;
import com.example.familiada.models.Question;
import com.example.familiada.models.Session;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstStageApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        GlobalVar.mainStage = stage;
        GlobalVar.current_active_question = new ActiveQuestion(GlobalVar.current_session.getQuestions().get(0), GlobalVar.current_session, GlobalVar.current_round - 1);
        Question q = GlobalVar.current_active_question.getQuestion();

        System.out.println("this question has " + q.getNumber_of_answers() + " answers.");
        GlobalVar.current_active_question = new ActiveQuestion(q, GlobalVar.current_session, GlobalVar.current_round);
        FXMLLoader fxmlLoader = new FXMLLoader(FirstStageApplication.class.getResource("firststage-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        System.out.println("jest runda " + GlobalVar.current_round);
        stage.setTitle("Runda pierwsza");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        GlobalVar.current_session = new Session();
        addQuestions(GlobalVar.current_session);

        launch();
    }

    static void addQuestions(Session s) {
        s.addQuestion("Najpopularniejsze telefony Polaków w 2022",
                new String[] {"SAMSUNG", "XIAOMI", "REALME", "APPLE", "LENOVO/MOTOROLA"},
                new int[] {31, 25, 13, 10, 6});

        s.addQuestion("Najbardziej obserwowane osoby na Instagramie",
                new String[] {"@CRISTIANO", "@KYLIEJENNER", "@LEOMESSI", "@SELENAGOMEZ", "@THEROCK", "@KIMKARDASHIAN"},
                new int[] {26, 22, 18, 14, 10, 6});

        s.addQuestion("Zwierzęta hodowlane, których jest najwięcej",
                new String[] {"KURCZAKI", "BYDŁO", "OWCE", "KACZKI", "KOZY", "TRZODA CHLEWNA"},
                new int[] {26, 22, 18, 14, 10, 6});

        s.addQuestion("Najczęstsze nazwiska Polaków",
                new String[] {"NOWAK", "KOWALSK*", "WIŚNIEWSK*"},
                new int[] {32, 30, 25});

        s.addQuestion("Największe sieci sklepów spożywczych w Polsce",
                new String[] {"ABC", "ŻABKA", "LEWIATAN", "BIEDRONKA"},
                new int[] {28, 26, 25, 18});
    }
}