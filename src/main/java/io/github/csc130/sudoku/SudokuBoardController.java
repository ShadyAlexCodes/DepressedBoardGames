package io.github.csc130.sudoku;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimerTask;

public class SudokuBoardController implements Initializable {
    @FXML
    private TextField box00 = new TextField();
    @FXML
    private TextField box01 = new TextField();
    @FXML
    private TextField box02 = new TextField();
    @FXML
    private TextField box03 = new TextField();
    @FXML
    private TextField box04 = new TextField();
    @FXML
    private TextField box05 = new TextField();
    @FXML
    private TextField box06 = new TextField();
    @FXML
    private TextField box07 = new TextField();
    @FXML
    private TextField box08 = new TextField();
    @FXML
    private TextField box10 = new TextField();
    @FXML
    private TextField box11 = new TextField();
    @FXML
    private TextField box12 = new TextField();
    @FXML
    private TextField box13 = new TextField();
    @FXML
    private TextField box14 = new TextField();
    @FXML
    private TextField box15 = new TextField();
    @FXML
    private TextField box16 = new TextField();
    @FXML
    private TextField box17 = new TextField();
    @FXML
    private TextField box18 = new TextField();
    @FXML
    private TextField box20 = new TextField();
    @FXML
    private TextField box21 = new TextField();
    @FXML
    private TextField box22 = new TextField();
    @FXML
    private TextField box23 = new TextField();
    @FXML
    private TextField box24 = new TextField();
    @FXML
    private TextField box25 = new TextField();
    @FXML
    private TextField box26 = new TextField();
    @FXML
    private TextField box27 = new TextField();
    @FXML
    private TextField box28 = new TextField();
    @FXML
    private TextField box30 = new TextField();
    @FXML
    private TextField box31 = new TextField();
    @FXML
    private TextField box32 = new TextField();
    @FXML
    private TextField box33 = new TextField();
    @FXML
    private TextField box34 = new TextField();
    @FXML
    private TextField box35 = new TextField();
    @FXML
    private TextField box36 = new TextField();
    @FXML
    private TextField box37 = new TextField();
    @FXML
    private TextField box38 = new TextField();
    @FXML
    private TextField box40 = new TextField();
    @FXML
    private TextField box41 = new TextField();
    @FXML
    private TextField box42 = new TextField();
    @FXML
    private TextField box43 = new TextField();
    @FXML
    private TextField box44 = new TextField();
    @FXML
    private TextField box45 = new TextField();
    @FXML
    private TextField box46 = new TextField();
    @FXML
    private TextField box47 = new TextField();
    @FXML
    private TextField box48 = new TextField();
    @FXML
    private TextField box50 = new TextField();
    @FXML
    private TextField box51 = new TextField();
    @FXML
    private TextField box52 = new TextField();
    @FXML
    private TextField box53 = new TextField();
    @FXML
    private TextField box54 = new TextField();
    @FXML
    private TextField box55 = new TextField();
    @FXML
    private TextField box56 = new TextField();
    @FXML
    private TextField box57 = new TextField();
    @FXML
    private TextField box58 = new TextField();
    @FXML
    private TextField box60 = new TextField();
    @FXML
    private TextField box61 = new TextField();
    @FXML
    private TextField box62 = new TextField();
    @FXML
    private TextField box63 = new TextField();
    @FXML
    private TextField box64 = new TextField();
    @FXML
    private TextField box65 = new TextField();
    @FXML
    private TextField box66 = new TextField();
    @FXML
    private TextField box67 = new TextField();
    @FXML
    private TextField box68 = new TextField();
    @FXML
    private TextField box70 = new TextField();
    @FXML
    private TextField box71 = new TextField();
    @FXML
    private TextField box72 = new TextField();
    @FXML
    private TextField box73 = new TextField();
    @FXML
    private TextField box74 = new TextField();
    @FXML
    private TextField box75 = new TextField();
    @FXML
    private TextField box76 = new TextField();
    @FXML
    private TextField box77 = new TextField();
    @FXML
    private TextField box78 = new TextField();
    @FXML
    private TextField box80 = new TextField();
    @FXML
    private TextField box81 = new TextField();
    @FXML
    private TextField box82 = new TextField();
    @FXML
    private TextField box83 = new TextField();
    @FXML
    private TextField box84 = new TextField();
    @FXML
    private TextField box85 = new TextField();
    @FXML
    private TextField box86 = new TextField();
    @FXML
    private TextField box87 = new TextField();
    @FXML
    private TextField box88 = new TextField();
    @FXML
    private Label responseText = new Label();
    private TextField[][] UIBoard = new TextField[9][9];

    private Sudoku sudoku = new Sudoku();
    Board board;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sudoku.setUpGame(SudokuMenuController.difficulty);
        putTextBoxesInArray();
        board = sudoku.getBoard();
        for (int i = 0; i < board.getNumberOfRows(); i++) {
            for (int j = 0; j < board.getNumberOfColumns(); j++) {
                if(board.getBoard()[i][j] > 0 && 10 < board.getBoard()[i][j]){
                    UIBoard[i][j].setText(String.valueOf(board.getBoard()[i][j]));
                    UIBoard[i][j].setEnabled(false);
                }
            }

        }
    }
    @FXML
    private void onSolveButtonClick(ActiveEvent event){
        for (int i = 0; i < board.getNumberOfRows(); i++) {
            for (int j = 0; j < board.getNumberOfColumns(); j++) {
                try {
                    if (Integer.parseInt(UIBoard[i][j].getText()) < 1 || Integer.parseInt(UIBoard[i][j].getText()) > 9) {
                        responseText.setText("There are invalid numbers on the board");
                        return;
                    } else {
                        board.getBoard()[i][j] = Integer.parseInt(UIBoard[i][j].getText());
                    }
                } catch (NumberFormatException e){
                    responseText.setText("There are letters on the board. Numbers only!");
                }

            }

        }
        if(sudoku.checkForWin()){
            responseText.setText("Congradulations you completed the Sudoku!");
        }
    }

    @FXML
    private void onNewGameButtonClick(ActiveEvent event){
        try {
            com.example.javafx.ChangeScene.changeScene((Event) event, "SudokuMenu.fxml");
        }catch (IOException e){
            System.out.println(e);
        }
    }

    private void putTextBoxesInArray(){
        UIBoard[0][0] = box00;
        UIBoard[0][1] = box01;
        UIBoard[0][2] = box02;
        UIBoard[0][3] = box03;
        UIBoard[0][4] = box04;
        UIBoard[0][5] = box05;
        UIBoard[0][6] = box06;
        UIBoard[0][7] = box07;
        UIBoard[0][8] = box08;
        UIBoard[1][0] = box10;
        UIBoard[1][1] = box11;
        UIBoard[1][2] = box12;
        UIBoard[1][3] = box13;
        UIBoard[1][4] = box14;
        UIBoard[1][5] = box15;
        UIBoard[1][6] = box16;
        UIBoard[1][7] = box17;
        UIBoard[1][8] = box18;
        UIBoard[2][0] = box20;
        UIBoard[2][1] = box21;
        UIBoard[2][2] = box22;
        UIBoard[2][3] = box23;
        UIBoard[2][4] = box24;
        UIBoard[2][5] = box25;
        UIBoard[2][6] = box26;
        UIBoard[2][7] = box27;
        UIBoard[2][8] = box28;
        UIBoard[3][0] = box30;
        UIBoard[3][1] = box31;
        UIBoard[3][2] = box32;
        UIBoard[3][3] = box33;
        UIBoard[3][4] = box34;
        UIBoard[3][5] = box35;
        UIBoard[3][6] = box36;
        UIBoard[3][7] = box37;
        UIBoard[3][8] = box38;
        UIBoard[4][0] = box40;
        UIBoard[4][1] = box41;
        UIBoard[4][2] = box42;
        UIBoard[4][3] = box43;
        UIBoard[4][4] = box44;
        UIBoard[4][5] = box45;
        UIBoard[4][6] = box46;
        UIBoard[4][7] = box47;
        UIBoard[4][8] = box48;
        UIBoard[5][0] = box50;
        UIBoard[5][1] = box51;
        UIBoard[5][2] = box52;
        UIBoard[5][3] = box53;
        UIBoard[5][4] = box54;
        UIBoard[5][5] = box55;
        UIBoard[5][6] = box56;
        UIBoard[5][7] = box57;
        UIBoard[5][8] = box58;
        UIBoard[6][0] = box60;
        UIBoard[6][1] = box61;
        UIBoard[6][2] = box62;
        UIBoard[6][3] = box63;
        UIBoard[6][4] = box64;
        UIBoard[6][5] = box65;
        UIBoard[6][6] = box66;
        UIBoard[6][7] = box67;
        UIBoard[6][8] = box68;
        UIBoard[7][0] = box70;
        UIBoard[7][1] = box71;
        UIBoard[7][2] = box72;
        UIBoard[7][3] = box73;
        UIBoard[7][4] = box74;
        UIBoard[7][5] = box75;
        UIBoard[7][6] = box76;
        UIBoard[7][7] = box77;
        UIBoard[7][8] = box78;
        UIBoard[8][0] = box80;
        UIBoard[8][1] = box81;
        UIBoard[8][2] = box82;
        UIBoard[8][3] = box83;
        UIBoard[8][4] = box84;
        UIBoard[8][5] = box85;
        UIBoard[8][6] = box86;
        UIBoard[8][7] = box87;
        UIBoard[8][8] = box88;
    }


}
