/**
 * @author Rishabh Dalal
 *
 */

package chess.pieces;
import java.util.ArrayList;

import chess.Board;
import chess.Move;

public class Rook extends Piece {

	public Rook(boolean color) {
		super(color);
		value = 50;
	}
	
	public int pieceInt() {
		return 2;
	}

	public Rook clone() {
		return new Rook(col);
	}

	public String toString() {
		if(col == Piece.WHITE)
			return "R";
		else
			return "r";
	}
	
	//White .. Red, Black .. Blue   -- for linux
	/*
	public String toString() {
		if(col == Piece.WHITE)
			return ConsoleColor.RED + "R" + ConsoleColor.RESET;
		else
			return ConsoleColor.BLUE + "r" + ConsoleColor.RESET;
	}
	*/
	
	public ArrayList<Move> getAllPossibleMoves(Board b, int x, int y) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		// up
		for(int i = 1; i < 8; i++) {
			if(valid(x, y+i)) {
				if(b.getTile(x, y+i).isOccupied()) {
					if(b.getTile(x, y+i).getPiece().col != col)
						moves.add(new Move(x,y,x,y+i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x,y+i));	
			}
		}
		
		// down
		for(int i = 1; i < 8; i++) {
			if(valid(x, y-i)) {
				if(b.getTile(x, y-i).isOccupied()) {
					if(b.getTile(x, y-i).getPiece().col != col)
						moves.add(new Move(x,y,x,y-i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x,y-i));	
			}
		}
		
		// left
		for(int i = 1; i < 8; i++) {
			if(valid(x-i, y)) {
				if(b.getTile(x-i, y).isOccupied()) {
					if(b.getTile(x-i, y).getPiece().col != col)
						moves.add(new Move(x,y,x-i,y));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x-i,y));	
			}
		}
		
		// right
		for(int i = 1; i < 8; i++) {
			if(valid(x+i, y)) {
				if(b.getTile(x+i, y).isOccupied()) {
					if(b.getTile(x+i, y).getPiece().col != col)
						moves.add(new Move(x,y,x+i,y));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x+i,y));	
			}
		}
		
		
		return moves;
	}
}
