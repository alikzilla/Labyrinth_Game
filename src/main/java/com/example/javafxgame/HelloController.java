package com.example.javafxgame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Circle player;

    @FXML
    private Rectangle sq1;

    @FXML
    private Rectangle sq2;

    @FXML
    private Rectangle sq3;

    @FXML
    private Rectangle sqEnd;

    @FXML
    void initialize() {

        Drag drag = new Drag(player, true);

        player.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                Bounds circleBounds = player.getBoundsInParent();
                Bounds rectBounds1 = sq1.getBoundsInParent();
                Bounds rectBounds2 = sq2.getBoundsInParent();
                Bounds rectBounds3 = sq3.getBoundsInParent();
                Bounds rectBounds4 = sqEnd.getBoundsInParent();

                if (circleBounds.intersects(rectBounds1)
                        || circleBounds.intersects(rectBounds2)
                        || circleBounds.intersects(rectBounds3)) {

                    System.out.println("ok");
                    alert("lose", "you lose");
                    player.getScene().getWindow().hide();

                }else if (circleBounds.intersects(rectBounds4)){

                    System.out.println("gratz");

                    player.getScene().getWindow().hide();

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(HelloController.class.getResource("level2.fxml"));

                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("game");
                    stage.show();

                }
            }
        });
    }
    public void alert(String title, String head){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.show();
    }

    public void alert1(String title, String head){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.show();
    }

}
