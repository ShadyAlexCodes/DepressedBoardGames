package io.github.csc130.checkers.players;

import io.github.csc130.checkers.game.GameBoard;
import io.github.csc130.utils.Utils;

public class CheckersHuman extends CheckersPlayer {


	public CheckersHuman(String name, char character) {
		super(name, character);
	}

	@Override
	public void takeTurn(GameBoard board) {
		boolean validMove = false;

		while (!validMove) {

			int fromRow = Utils.getIntInput("(" + getName() + ") From Row: ", Utils.TextColor.BLUE) - 1;
			int fromCol = Utils.getIntInput("(" + getName() + ") From Col: ", Utils.TextColor.BLUE) - 1;
			int toRow = Utils.getIntInput("(" + getName() + ") To Row: ", Utils.TextColor.CYAN) - 1;
			int toCol = Utils.getIntInput("(" + getName() + ") To Col: ", Utils.TextColor.CYAN) - 1;

			if (isValidMove(board.getBoard(), fromRow, fromCol, toRow, toCol)) {
				validMove = true;
				board.getBoard()[toRow][toCol] = board.getBoard()[fromRow][fromCol];
				board.getBoard()[fromRow][fromCol] = ' ';
				if (Math.abs(toRow - fromRow) == 2) {
					board.getBoard()[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = ' ';
				}
			} else {
				Utils.writeLn("You made an invalid move!", Utils.TextColor.RED);
				board.printBoard();
			}
		}
	}


	private boolean isValidMove(char[][] board, int fromRow, int fromCol, int toRow, int toCol) {
		// Check if from and to positions are within the bounds of the board
		if (fromRow < 0 || fromRow > 7 || fromCol < 0 || fromCol > 7 || toRow < 0 || toRow > 7 || toCol < 0 ||
				    toCol > 7) {
			return false;
		}

		// Check if from position is occupied by current player's character
		if (board[fromRow][fromCol] != getCharacter() &&
				    board[fromRow][fromCol] != Character.toUpperCase(getCharacter())) {
			return false;
		}

		// Check if to position is occupied
		if (board[toRow][toCol] != ' ') {
			return false;
		}

		int rowDiff = toRow - fromRow;
		int colDiff = toCol - fromCol;
		int midRow = (fromRow + toRow) / 2;
		int midCol = (fromCol + toCol) / 2;

		// Check if move is a valid diagonal move
		if (Math.abs(rowDiff) != Math.abs(colDiff)) {
			return false;
		}

		// Check if move is proper distance and direction
		switch (board[fromRow][fromCol]) {
			// Assumes red is at the top of the board
			case 'r' -> {
				if (rowDiff > 2 || rowDiff < 1) {
					return false;
				} else if (rowDiff == 2) {
					// Check for valid jump
					if (board[midRow][midCol] == ' ' || board[midRow][midCol] == getCharacter() ||
							    board[midRow][midCol] == Character.toUpperCase(getCharacter())) {
						return false;
					}
				}
			}
			case 'b' -> {
				if (rowDiff < -2 || rowDiff > -1) {
					return false;
				} else if (rowDiff == -2) {
					if (board[midRow][midCol] == ' ' || board[midRow][midCol] == getCharacter() ||
							    board[midRow][midCol] == Character.toUpperCase(getCharacter())) {
						return false;
					}
				}
			}
			case 'R', 'B' -> {
				if (Math.abs(rowDiff) > 2 || Math.abs(rowDiff) < 1) {
					return false;
				} else if (Math.abs(rowDiff) == 2) {
					if (board[midRow][midCol] == ' ' || board[midRow][midCol] == getCharacter() ||
							    board[midRow][midCol] == Character.toUpperCase(getCharacter())) {
						return false;
					}
				}
			}
		}

		return true;
	}
}
