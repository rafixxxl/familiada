package com.example.familiada;

import com.example.familiada.models.ActiveQuestion;
import com.example.familiada.models.GlobalVar;
import com.example.familiada.models.Question;
import com.example.familiada.models.Session;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

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
        GlobalVar.currentScene = scene;
        System.out.println("jest runda " + GlobalVar.current_round);
        stage.setTitle("Runda pierwsza");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        GlobalVar.current_session = new Session();
        addQuestions(GlobalVar.current_session, new File("src/main/resources/com/example/familiada/question_sets/qs03.txt"));
        launch();
    }

    static void addQuestions(Session s, File file) throws IOException {
        Scanner sc = new Scanner(file);
        System.out.println(file.getCanonicalPath());
        while (sc.hasNextLine()) {
            String question = sc.nextLine();
            String line = sc.nextLine();
            if (sc.hasNextLine()) sc.nextLine();
            String[] part = line.split(" *: *");
            String[] answer = part[0].split(" *, *");
            String[] points = part[1].split(" *, *");
            if (answer.length != points.length) {
                System.out.println("IMPORT ERROR!");
                System.exit(0);
            }
            int[] points_int = Arrays.stream(points).mapToInt(Integer::parseInt).toArray();
            s.addQuestion(question, answer, points_int);
        }
    }
}