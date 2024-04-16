package player;

import piece.Piece;
import piece.PieceType;

public class Player {
	String name;
	Piece piece;
	
	public Player(String name, Piece piece) {
		this.name = name;
		this.piece = piece;
	}

	public String getName() {
		return name;
	}


	public Piece getPiece() {
		return piece;
	}	
	
}
