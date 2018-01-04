/**
 * @author Rishabh Dalal
 *
 */

package chess;
import chess.pieces.Piece;

public class Tile {
	private boolean occupied;
	private Piece piece;

	/**
	 * 
	 */
	public Tile() {
		occupied = false;
	}
	
	public Tile(Tile aTile) {
		this.occupied = aTile.isOccupied();
		this.piece = aTile.isOccupied() ? aTile.getPiece().clone() : null;
	}
	
	public Tile(Piece aPiece) {
		occupied = true;
		this.piece = aPiece;
	}
	
	public String toString() {
		if(occupied)
			return piece.toString();
		else
			return ".";
	}

	public Piece getPiece() {
		return piece;
	}
	
	public boolean isOccupied() {
		return occupied;
	}

}
