/**
 * @author Xander
 * @createdOn 2/6/2023 at 2:01 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130.tictactoe;
 */
package io.github.csc130.tictactoe;

import java.util.*;

public class TicTacToeRunner {
    static ArrayList<Integer> playerPositions =  new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions =  new ArrayList<Integer>();

    public void startGame(){
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, //row 0
                {'-', '+', '-', '+', '-'}, //row 1
                {' ', '|', ' ', '|', ' '}, //row 2
                {'-', '+', '-', '+', '-'}, //row 3
                {' ', '|', ' ', '|', ' '}}; //row 4

        printGameBoard(gameBoard);

        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9):");
            int playerPosition = scan.nextInt();
            System.out.println(playerPosition);

            //placement check
            while(playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)){
                System.out.println("Position taken! Enter a correct one:");
                playerPosition = scan.nextInt();
            }
            //piece placement (player)
            placePiece(gameBoard,playerPosition, "Player");
            String endgame = checkWinner();
            if(endgame.length() > 0){
                System.out.println(endgame);
                break;
            }

            //piece placement (cpu)
            Random rand = new Random();
            int cpuPos = rand.nextInt(9)+1;
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
                System.out.println("Position taken! Enter a correct one:");
                cpuPos = rand.nextInt(9)+1;
            }
            placePiece(gameBoard,cpuPos, "CPU");
            printGameBoard(gameBoard);
            endgame = checkWinner();
            if(endgame.length() > 0){
                System.out.println(endgame);
                break;
            }

        }
    }

    public static void printGameBoard(char[][] gameBoard){
        for(char[] row : gameBoard){
            for(char col : row){
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int position, String user){
        char symbol = ' ';
        if(user.equals("Player")){
            symbol = 'X';
            playerPositions.add(position);
        } else if(user.equals("CPU")){
            symbol = 'O';
            cpuPositions.add(position);
        }

        switch(position){
            //goes on each individual box of the board [row][column] (yeah it's redundant, but it should still work
            //it should re-print the board once the user has entered a number
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
        }

    }

    public static String checkWinner(){

        //row lineup
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);

        //column lineup
        List rightCol = Arrays.asList(3,6,9);
        List midCol = Arrays.asList(2,5,8);
        List leftCol = Arrays.asList(1,4,7);

        //vertical lineup
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> win = new ArrayList<>();
        win.add(topRow);
        win.add(midRow);
        win.add(botRow);
        win.add(rightCol);
        win.add(midCol);
        win.add(leftCol);
        win.add(cross2);
        win.add(cross1);

        for(List l : win){
            if(playerPositions.containsAll(l)){
                return "Congratulations! You win!!";
            } else if (cpuPositions.containsAll(l)){
                return "Looks like the Bot bested you, you'll get 'em next time";
            } else if(playerPositions.size() + cpuPositions.size() ==9){
                return "CAT!!";
            }
        }

        return "";
    }

}
