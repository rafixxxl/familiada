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

    String[] numerals = new String[] {"pierwsza", "druga", "trzecia", "czwarta", "piąta", "szósta", "siódma", "ósma"};

    @Override
    public void start(Stage stage) throws IOException {
        GlobalVar.current_active_question = new ActiveQuestion(GlobalVar.current_session.getQuestions().get(0), GlobalVar.current_session, GlobalVar.current_round - 1);
        Question q = GlobalVar.current_active_question.getQuestion();

        System.out.println("this question has " + q.getNumber_of_answers() + " answers.");
        GlobalVar.current_active_question = new ActiveQuestion(q, GlobalVar.current_session, GlobalVar.current_round);
        FXMLLoader fxmlLoader = new FXMLLoader(FirstStageApplication.class.getResource("firststage-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("Runda " + numerals[GlobalVar.current_round - 1]);
        stage.setScene(scene);
        stage.show();
        FirstStageController.playSound("start_round.wav");
    }

    public static void main(String[] args) {
        GlobalVar.current_session = new Session();
        addQuestions(GlobalVar.current_session);

        launch();
    }

    static void addQuestions(Session s) {
        s.addQuestion("Wielcy Polacy",
                new String[] {"Karol Wojtyła", "Mariusz Pudzianowski", "Adam Małysz", "Robert Kubica", "Norbi"},
                new int[] {23, 20, 15, 14, 10});

        s.addQuestion("Więcej niż jedno zwierzę to",
                new String[] {"Lama", "Owca", "Fusion Suszec", "TCS", "Feministki"},
                new int[] {25, 24, 22, 20, 7});

        s.addQuestion("Smaki lodów Iza",
                new String[] {"Truskawkowe", "Śmietankowe", "Cytrynowe", "Czekoladowe", "Innych nie ma"},
                new int[] {25, 25, 25, 25, 0});

        s.addQuestion("Co jest w cieście na stole",
                new String[] {"Czekolada", "Ziemniaki", "Kuskus"},
                new int[] {28, 26, 25});
    }
}