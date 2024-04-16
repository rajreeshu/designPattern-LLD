package game;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import piece.PieceO;
import piece.PieceX;
import player.Player;

public class TikTacToeGame {
	Board board;
	Deque<Player> players = new ArrayDeque<>();
	GameResult winner = GameResult.ONGOING;

	public TikTacToeGame(Board board) {
		this.board = board;
		this.players.addAll(players);
	}
	
	public void initalize() {
		players.add(new Player("Reeshu",new PieceX()));
		players.add(new Player("Amlan",new PieceO()));
		
	}

	public void start() {
		while (winner == GameResult.ONGOING) {
			Player currentPlayer = players.removeFirst();
			board.printBoard();
			System.out.println(
					currentPlayer.getName() + "'s chance to Play. \nPlease give the x and y indices to add the mark.");

			Scanner sc = new Scanner(System.in);
			int i = sc.nextInt();
			int j = sc.nextInt();
			boolean isFilled = board.fill(currentPlayer, i, j);
			winner = checkWinner(currentPlayer);
			switch (winner) {
			case WINNER:
				System.out.println(currentPlayer.getName() + " won the game");
				return;
			case DRAW:
				System.out.println("Match is Tie.");
				return;
			default:
				break;
			}
			if (isFilled) {
				players.addLast(currentPlayer);
			} else {
				players.addFirst(currentPlayer);
			}
			;
		}
	}

	public GameResult checkWinner(Player player) {
		// Check rows and columns
		for (int i = 0; i < board.size; i++) {
			if (board.board[i][0] != null && board.board[i][0] == board.board[i][1] && board.board[i][1] == board.board[i][2]) {
				return GameResult.WINNER;
			}
			if (board.board[0][i] != null && board.board[0][i] == board.board[1][i] && board.board[1][i] == board.board[2][i]) {
				return GameResult.WINNER;
			}
		}

		// Check diagonals
		if (board.board[0][0] != null && board.board[0][0] == board.board[1][1] && board.board[1][1] == board.board[2][2]) {
			return GameResult.WINNER;
		}
		if (board.board[0][2] != null && board.board[0][2] == board.board[1][1] && board.board[1][1] == board.board[2][0]) {
			return GameResult.WINNER;
		}

		// Check for a draw or ongoing game
		for (int i = 0; i < board.size; i++) {
			for (int j = 0; j < board.size; j++) {
				if (board.board[i][j] == null) {
					return GameResult.ONGOING;
				}
			}
		}

		return GameResult.DRAW;

	}
}
