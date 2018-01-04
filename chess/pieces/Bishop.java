/**
 * @author Rishabh Dalal
 *
 */

package chess.pieces;
import java.util.ArrayList;

import chess.*;

public class Bishop extends Piece {

	public Bishop(boolean color) {
		super(color);
		value = 30;
	}
	
	public int pieceInt() {
		return 3;
	}
	
	public String toString() {
		if(col == Piece.WHITE)
			return "B";
		else
			return "b";
	}
	
	//White .. Red, Black .. Blue   -- for linux
	/*
	public String toString() {
		if(col == Piece.WHITE)
			return ConsoleColor.RED + "B" + ConsoleColor.RESET;
		else
			return ConsoleColor.BLUE + "b" + ConsoleColor.RESET;
	}
	*/
	
	public Bishop clone() {
		return new Bishop(col);
	}

	public ArrayList<Move> getAllPossibleMoves(Board b, int x, int y) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		
		// NE
		for(int i = 1; i < 8; i++) {
			if(valid(x+i, y+i)) {
				if(b.getTile(x+i, y+i).isOccupied()) {
					if(b.getTile(x+i, y+i).getPiece().col != col)
						moves.add(new Move(x,y,x+i,y+i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x+i,y+i));	
			}
		}
		
		// NW
		for(int i = 1; i < 8; i++) {
			if(valid(x-i, y+i)) {
				if(b.getTile(x-i, y+i).isOccupied()) {
					if(b.getTile(x-i, y+i).getPiece().col != col)
						moves.add(new Move(x,y,x-i,y+i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x-i,y+i));	
			}
		}
		
		// SE
		for(int i = 1; i < 8; i++) {
			if(valid(x+i, y-i)) {
				if(b.getTile(x+i, y-i).isOccupied()) {
					if(b.getTile(x+i, y-i).getPiece().col != col)
						moves.add(new Move(x,y,x+i,y-i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x+i,y-i));	
			}
		}
		
		// SW
		for(int i = 1; i < 8; i++) {
			if(valid(x-i, y-i)) {
				if(b.getTile(x-i, y-i).isOccupied()) {
					if(b.getTile(x-i, y-i).getPiece().col != col)
						moves.add(new Move(x,y,x-i,y-i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x-i,y-i));	
			}
		}
		
		return moves;
	}
}
