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
import java.util.Scanner;

public class FirstStageApplication extends Application {

    String[] numerals = new String[] {"pierwsza", "druga", "trzecia", "czwarta", "piąta", "szósta", "siódma"};

    @Override
    public void start(Stage stage) throws IOException {

        GlobalVar.current_session = new Session();
        addQuestions(GlobalVar.current_session);

        for (Question q : GlobalVar.current_session.getQuestions()) {
            GlobalVar.current_active_question = new ActiveQuestion(q, GlobalVar.current_session, GlobalVar.current_round);
            FXMLLoader fxmlLoader = new FXMLLoader(FirstStageApplication.class.getResource("firststage-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
            stage.setTitle("Runda " + numerals[GlobalVar.current_round - 1]);
            stage.setScene(scene);
            stage.show();
        }

    }

    public static void main(String[] args) {
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
                new String[] {"Czekolada", "Ziemniaki", "Kuskus", "Jajka", "Papryka słodka"},
                new int[] {25, 25, 25, 20, 5});
    }

    static void handleAnswer(int number, int team, ActiveQuestion activeQuestion) {
        if (number == 0) {
            activeQuestion.guessWrong(team);
            System.out.println("Team " + team + " has just guessed incorrectly.");
        }
        else {
            activeQuestion.guessOne(number, team);
            System.out.println("Team " + team + " has just guessed no. " + number + " and the sum is now " + activeQuestion.getSum());
        }
    }

    static void lastQuestion(ActiveQuestion activeQuestion) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Last question: which team guesses?");
        int team = scanner.nextInt();
        System.out.println("Answer:");
        int number = scanner.nextInt();
        handleAnswer(number, team, activeQuestion);
        if (number != 0) activeQuestion.end(team);
        else activeQuestion.end(3 - team);
    }
}