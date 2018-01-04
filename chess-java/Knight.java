/**
 * @author Rishabh Dalal
 *
 */

import java.util.ArrayList;



public class Knight extends Piece {

	public Knight(boolean color) {
		super(color);
		value = 30;
	}
	
	public int pieceInt() {
		return 4;
	}
	
	public Knight clone() {
		return new Knight(col);
	}	

	public String toString() {
		if(col == Piece.WHITE)
			return "N";
		else
			return "n";
	}
	
	//White .. Red, Black .. Blue   -- for linux
	/*
	public String toString() {
		if(col == Piece.WHITE)
			return ConsoleColor.RED + "N" + ConsoleColor.RESET;
		else
			return ConsoleColor.BLUE + "n" + ConsoleColor.RESET;
	}
	*/
	
	public ArrayList<Move> getAllPossibleMoves(Board b, int x, int y) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		// NNE
		if(valid(x+1, y+2) && 
				(!b.getTile(x+1, y+2).isOccupied() || 
						(b.getTile(x+1, y+2).isOccupied() && b.getTile(x+1, y+2).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x+1, y+2));
		
		// ENE
		if(valid(x+2, y+1) && 
				(!b.getTile(x+2, y+1).isOccupied() || 
						(b.getTile(x+2, y+1).isOccupied() && b.getTile(x+2, y+1).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x+2, y+1));
		
		// ESE
		if(valid(x+2,y-1) && 
				(!b.getTile(x+2,y-1).isOccupied() || 
						(b.getTile(x+2,y-1).isOccupied() && b.getTile(x+2,y-1).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x+2,y-1));
		
		
		// SSE
		if(valid(x+1,y-2) && 
				(!b.getTile(x+1,y-2).isOccupied() || 
						(b.getTile(x+1,y-2).isOccupied() && b.getTile(x+1,y-2).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x+1,y-2));
		
		// SSW
		if(valid(x-1,y-2) && 
				(!b.getTile(x-1,y-2).isOccupied() || 
						(b.getTile(x-1,y-2).isOccupied() && b.getTile(x-1,y-2).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x-1,y-2));
		
		// WSW
		if(valid(x-2,y-1) && 
				(!b.getTile(x-2,y-1).isOccupied() || 
						(b.getTile(x-2,y-1).isOccupied() && b.getTile(x-2,y-1).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x-2,y-1));
		
		// WNW
		if(valid(x-2,y+1) && 
				(!b.getTile(x-2,y+1).isOccupied() || 
						(b.getTile(x-2,y+1).isOccupied() && b.getTile(x-2,y+1).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x-2,y+1));
		
		// NNW
		if(valid(x-1,y+2) && 
				(!b.getTile(x-1,y+2).isOccupied() || 
						(b.getTile(x-1,y+2).isOccupied() && b.getTile(x-1,y+2).getPiece().getColor() != col)))
			moves.add(new Move(x,y,x-1,y+2));
		
		return moves;
	}
}
