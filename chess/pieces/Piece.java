/**
 *@author Rishabh Dalal
 * 
 * 	Pawn 	... 	1
 * 	Rook 	... 	2
 * 	Bishop 	... 	3
 * 	Knight 	... 	4
 * 	Queen 	... 	5
 * 	King 	... 	6
 */

package chess.pieces;
import chess.Board;
import chess.Move;
import java.util.ArrayList;

/*
 * Value of various pieces:
 * Pawn 	...  10
 * Bishop 	...  30
 * Knight	...  30
 * Rook 	...	 50
 * Queen 	...	 90
 * King 	...	 900
 */

public abstract class Piece {
	public static final boolean WHITE = true, BLACK = false;
	protected boolean col;
	protected int value;
	private final static int ROW = 7;
	private final static int COLUMN = 7;
	
	public boolean getColor() {
		return col;
	}

	public Piece(boolean color) {
		this.col = color;
		value = 0;
	}
	
	public int getValue() {
		return value;
	}
	
	public abstract int pieceInt();
	
	public abstract Piece clone();
	
	public abstract ArrayList<Move> getAllPossibleMoves(Board b, int x, int y);
	
	/**
	 * @param b .. Board
	 * @param x .. x coordinate of piece
	 * @param y .. y coordinate of piece
	 * @return
	 */
	static public boolean valid(int x, int y) {
		if(x < 0 || x > ROW || y < 0 || y > COLUMN)
			return false;
		else
			return true;
	}
}
