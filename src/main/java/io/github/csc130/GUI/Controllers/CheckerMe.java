package io.github.csc130.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CheckerMe implements Initializable {
    @FXML
    Button btnSlay;
    @FXML
    ComboBox gameModeDrop;
    @FXML
    ComboBox diffDrop;
    @FXML
    Button btnRTMM;
    @FXML
    Button btnQuit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //difficulty settings
        diffDrop.getItems().add("Easy");
        diffDrop.getItems().add("Medium");
        diffDrop.getItems().add("Harder daddy");

        //game mode settings
        gameModeDrop.getItems().add("Player vs Player");
        gameModeDrop.getItems().add("Player vs CPU");
        gameModeDrop.getItems().add("CPU vs CPU");



    }
}
