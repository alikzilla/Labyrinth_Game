package com.example.javafxgame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Gratz {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button press;

    @FXML
    void initialize() {
        press.setOnAction(actionEvent -> {
            try {
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(String.valueOf("https://www.youtube.com/watch?v=UGuWUCId2W8&ab_channel=aviarezhym")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
