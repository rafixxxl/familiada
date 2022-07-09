package com.example.familiada;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FirstStageController {

    public Button next_round_button;

    @FXML
    public void GoToNextRound() {
        System.out.println("New round!");
    }
}