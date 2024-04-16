package main;

import game.Board;
import game.TikTacToeGame;

public class Start {
	public static void main(String args[]) {
		Board board = new Board(3);
		TikTacToeGame game = new TikTacToeGame(board);
		game.initalize();
		game.start();
		
	}
}
