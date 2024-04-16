package game;

import java.util.logging.Logger;

import piece.Piece;
import player.Player;

public class Board {
	int size;
	public Piece board[][];

	Logger logger = Logger.getLogger(this.getClass().getName());

	public Board(int size) {
		this.size = size;
		board = new Piece[size][size];
	}

	public void printBoard() {
		int n = size;

		// Calculate the number of rows and columns for the boundary
		int rows = 2 * n + 1;
		int columns = 4 * n + 1;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i % 2 == 0) { // Horizontal boundary row
					if (j % 4 == 0) {
						System.out.print("+");
					} else {
						System.out.print("-");
					}
				} else { // Vertical boundary row
					if (j % 4 == 0) {
						System.out.print("|");
					} else if (j % 2 == 0) {
						if (board[i / 2][j / 4] != null)
							System.out.print(board[i / 2][j / 4].getPiece().toString());
						else {
							System.out.print(" ");
						}
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println(); // Move to the next line after each row is printed
		}
	}

	

	public boolean fill(Player player, int i, int j) {
		if (i < 0 || i > size - 1 || j < 0 || j > size - 1) {
			logger.info("Invalid Indices found. \nPlease try again.");
			return false;
		}

		if (board[i][j] == null) {
			board[i][j] = player.getPiece();
			return true;
		} else {
			logger.info("Index is already filled. \nPlease try again.");
			return false;
		}
	}



}
