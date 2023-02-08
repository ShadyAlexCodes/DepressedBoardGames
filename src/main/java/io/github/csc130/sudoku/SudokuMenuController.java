package io.github.csc130.sudoku;

import javafx.event.Event;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;

public class SudokuMenuController {
    public static Difficulty difficulty;

    @FXML
    private void onEasyButtonClick(ActiveEvent event) {
        difficulty = Difficulty.EASY;
        try {
            com.example.javafx.ChangeScene.changeScene((Event) event, "SudokuBoard.fxml");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    @FXML
    private void onMediumButtonClick(ActiveEvent event)throws IOException{
        difficulty = Difficulty.MEDIUM;
        try {
            com.example.javafx.ChangeScene.changeScene((Event) event, "SudokuBoard.fxml");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    @FXML
    private void onHardButtonClick(ActiveEvent event)throws IOException{
        difficulty = Difficulty.HARD;
        try {
            com.example.javafx.ChangeScene.changeScene((Event) event, "SudokuBoard.fxml");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
