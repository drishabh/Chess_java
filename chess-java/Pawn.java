/**
 * @author Rishabh Dalal
 *
 */


import java.util.ArrayList;

public class Pawn extends Piece {

	public Pawn(boolean color) {
		super(color);
		value = 10;
	}
	
	public Pawn clone() {
		return new Pawn(col);
	}

	public String toString() {
		if(col == Piece.WHITE)
			return "P";
		else
			return "p";
	}
	
	//White .. Red, Black .. Blue   -- for linux
	/*
	public String toString() {
		if(col == Piece.WHITE)
			return ConsoleColor.RED + "P" + ConsoleColor.RESET;
		else
			return ConsoleColor.BLUE + "p" + ConsoleColor.RESET;
	}
	*/
	
	public int pieceInt() {
		return 1;
	}
	
	/**
	 * @param b Board
	 * @param x x location of piece
	 * @param y y location of piece
	 * @return
	 */
	public ArrayList<Move> getAllPossibleMoves(Board b, int x, int y) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		if(col == Piece.WHITE) {
			// forward
			if(valid(x,y+1) && !b.getTile(x, y+1).isOccupied())
				moves.add(new Move(x,y,x,y+1));
			
			// kill diagonally
			if(valid(x+1,y+1) && b.getTile(x+1, y+1).isOccupied() && b.getTile(x+1, y+1).getPiece().getColor() != col)
				moves.add(new Move(x,y,x+1,y+1));
			
			// kill diagonally
			if(valid(x-1,y+1) && b.getTile(x-1, y+1).isOccupied() && b.getTile(x-1, y+1).getPiece().getColor() != col)
				moves.add(new Move(x,y,x-1,y+1));
		}
		else {
			// forward
			if(valid(x,y-1) && !b.getTile(x, y-1).isOccupied())
				moves.add(new Move(x,y,x,y-1));
			
			// kill diagonally
			if(valid(x+1,y-1) && b.getTile(x+1, y-1).isOccupied() && b.getTile(x+1, y-1).getPiece().getColor() != col)
				moves.add(new Move(x,y,x+1,y-1));
			
			// kill diagonally
			if(valid(x-1,y-1) && b.getTile(x-1, y-1).isOccupied() && b.getTile(x-1, y-1).getPiece().getColor() != col)
				moves.add(new Move(x,y,x-1,y-1));
		}
		
		return moves;
	}
}
