/**
 * @author Rishabh Dalal
 *
 */

package chess.pieces;
import java.util.ArrayList;

import chess.Board;
import chess.Move;

public class King extends Piece {
	boolean hasMoved = false;

	/**
	 * 
	 */
	public King(boolean color) {
		super(color);
		value = 900;
	}
	
	public King(boolean color, boolean hasMoved) {
		super(color);
		this.hasMoved = hasMoved;
		value = 0;
	}

	public int pieceInt() {
		return 6;
	}
	
	public King clone() {
		return new King(col, hasMoved);
	}
	
	
	public String toString() {
		if(col == Piece.WHITE)
			return "K";
		else
			return "k";
	}
	
	
	//White .. Red, Black .. Blue   -- for linux
	/*
	public String toString() {
		if(col == Piece.WHITE)
			return ConsoleColor.RED + "K" + ConsoleColor.RESET;
		else
			return ConsoleColor.BLUE + "k" + ConsoleColor.RESET;
	}
	*/

	public ArrayList<Move> getAllPossibleMoves(Board b, int x, int y) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		// North
		if(valid(x, y+1) && 
				(!b.getTile(x, y+1).isOccupied() || 
						(b.getTile(x, y+1).isOccupied() && b.getTile(x, y+1).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x,y+1));
		
		// North East
		if(valid(x+1, y+1) && 
				(!b.getTile(x+1, y+1).isOccupied() || 
						(b.getTile(x+1, y+1).isOccupied() && b.getTile(x+1, y+1).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x+1,y+1));
		
		// East
		if(valid(x+1,y) && 
				(!b.getTile(x+1,y).isOccupied() || 
						(b.getTile(x+1,y).isOccupied() && b.getTile(x+1,y).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x+1,y));
		
		
		// South East
		if(valid(x+1,y-1) && 
				(!b.getTile(x+1,y-1).isOccupied() || 
						(b.getTile(x+1,y-1).isOccupied() && b.getTile(x+1,y-1).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x+1,y-1));
		
		// South
		if(valid(x,y-1) && 
				(!b.getTile(x,y-1).isOccupied() || 
						(b.getTile(x,y-1).isOccupied() && b.getTile(x,y-1).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x,y-1));
		
		// South West
		if(valid(x-1,y-1) && 
				(!b.getTile(x-1,y-1).isOccupied() || 
						(b.getTile(x-1,y-1).isOccupied() && b.getTile(x-1,y-1).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x-1,y-1));
		
		// West
		if(valid(x-1,y) && 
				(!b.getTile(x-1,y).isOccupied() || 
						(b.getTile(x-1,y).isOccupied() && b.getTile(x-1,y).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x-1,y));
		
		// North West
		if(valid(x-1,y+1) && 
				(!b.getTile(x-1,y+1).isOccupied() || 
						(b.getTile(x-1,y+1).isOccupied() && b.getTile(x-1,y+1).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x-1,y+1));

		// If castling
		if(col == Piece.WHITE) {
			if(!hasMoved && x == Board.e && y == 1-1) {
				if(!b.getTile(Board.f, 1-1).isOccupied() &&
						!b.getTile(Board.g, 1-1).isOccupied() &&
						b.getTile(Board.h, 1-1).isOccupied() && 
						b.getTile(Board.h, 1-1).getPiece().toString().equals("R"))
					moves.add(new Move(x,y,x+2,y));
					
						
			}
			else 
				hasMoved = true;
		}
		else { // if (color == BLACK{false})
			if(!hasMoved && x == Board.e && y == 8-1) {
				
			}
			else 
				hasMoved = true;
		}
				
		return moves;
	}
}
