package piece;

public abstract class Piece {
	private PieceType pieceType;

	public Piece(PieceType pieceType) {
		this.pieceType = pieceType;
	}
	
	public PieceType getPiece() {
		return this.pieceType;
	}
}
