package com.example.familiada;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstStageApplication extends Application {

    int round = 1;
    String[] numerals = new String[] {"pierwsza", "druga", "trzecia", "czwarta", "piąta", "szósta", "siódma"};

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FirstStageApplication.class.getResource("firststage-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("Runda " + numerals[round - 1]);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}