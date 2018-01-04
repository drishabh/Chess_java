/**
 * 
 * @author Rishabh Dalal
 *
 */


public class Validity {
	
	int playerSide, playerColor;;
	
	public Validity() {}
	
	public boolean isValid(int ox, int oy, int nx, int ny, Board chessBoard) {
		// Checking basic validity of move and sending to appropriate method based on the piece
		
		
		if (( chessBoard.getTile(ox, oy).getPiece()).getColor() != Piece.WHITE){
			return false;
		}
		if (chessBoard.getTile(nx, ny).isOccupied()) {
			if (chessBoard.getTile(nx, ny).getPiece().getColor() == Piece.WHITE) {return false;}
		}
		if ((ox == nx) && (oy==ny)) {return false;}
		
		if (chessBoard.getTile(ox, oy).getPiece().pieceInt() == 1) {
			return checkPawn(ox, oy, nx, ny, chessBoard);
		}
		else if (chessBoard.getTile(ox, oy).getPiece().pieceInt() == 2) {
			return checkRook(ox, oy, nx, ny, chessBoard);
		}
		
		else if (chessBoard.getTile(ox, oy).getPiece().pieceInt() == 3) {
			return checkBishop(ox, oy, nx, ny, chessBoard);
		}
		else if (chessBoard.getTile(ox, oy).getPiece().pieceInt() == 4) {
			return checkKnight(ox, oy, nx, ny, chessBoard);
		}
		else if (chessBoard.getTile(ox, oy).getPiece().pieceInt() == 5) {
			return checkQueen(ox, oy, nx, ny, chessBoard);
		}
		else if (chessBoard.getTile(ox, oy).getPiece().pieceInt() == 6) {
			return checkKing(ox, oy, nx, ny, chessBoard);
		}
		
		return false;
		
	}
	
	public boolean checkPawn(int x1, int y1, int x2, int y2, Board chessBoard){
		// Checking validity of move if selected piece is pawn
		
		if (x1 != x2) {
			if (y2-y1 == 1) {
				if (chessBoard.getTile(x2, y2).getPiece().getColor() == Piece.BLACK) {return true;}
				return false;
			}
			return false;
		}
		else {
			if ((y2-y1) == 1){
				
				if (chessBoard.getTile(x2, y2).isOccupied() == true) {
					return false;
				}
				else {return true;}
			}
			else if (((y2-y1)==2) && (y1 == 1)) {
				if ((chessBoard.getTile(x1, y1+1).isOccupied() == false)) {
					if (chessBoard.getTile(x2, y2).isOccupied() == false) {return true;}
					return false;
					}
				}
				return false;
			}
	}
	
	public boolean checkRook(int x1, int y1, int x2, int y2, Board chessBoard) {
		// Checking validity of move if selected piece is rook
		
		int i;
		if ((x1-x2) == 0) {
			if (y2 > y1) {
				for (i=y1+1; i<y2; i++) {
					if (chessBoard.getTile(x1,  i).isOccupied()) {return false;}
				}
				if (chessBoard.getTile(x2, y2).isOccupied() == true) {
					if (chessBoard.getTile(x2, y2).getPiece().getColor() == false) {return true;}
					return false;
				}
				else {return true;}
			}
			else if (y1 > y2) {
				for (i = y1-1; i > y2; i--) {
					if (chessBoard.getTile(x1, i).isOccupied()) {return false;}
				}
				if (chessBoard.getTile(x2, y2).isOccupied()) {
					if (chessBoard.getTile(x2, y2).getPiece().getColor() == false) {return true;}
					else {return false;}
				}
				else {return true;}
			}
			else {return false;}
		}
		
		else if ((y1-y2) == 0) {
			if (x2 > x1) {
				for (i=x1+1; i < x2; i++) {
					if (chessBoard.getTile(i, y1).isOccupied()) {return false;}
				}
				if (chessBoard.getTile(x2, y2).isOccupied()) {
					if (chessBoard.getTile(x2, y2).getPiece().getColor() == false) {return true;}
					else {return false;}
				}
				else {return true;}
			}
			else if (x1 > x2) {
				for (i=x1-1; i>x2; i--) {
					if (chessBoard.getTile(i, y1).isOccupied()) {return false;}
				}
				if (chessBoard.getTile(x2,  y2).isOccupied()) {
					if (chessBoard.getTile(x2, y2).getPiece().getColor() == false) {return true;}
					else {return false;}
				}
				else {return true;}
			}
			else {return false;}
		}
		
		return false;
	}
	
	public boolean checkBishop(int x1, int y1, int x2, int y2, Board chessBoard){
		// Checking validity of move if selected piece is bishop
		
		int i,j;
		if ((x2-x1) == 0) {return false;}
		float slope = (y2 - y1) / (x2-x1);
		if ((slope == 1.0) || (slope == -1.0)){
			if ((x2>x1) && (y2>y1)) {
				j=y1+1;
				for (i=x1+1; i<x2; i++) {
					if (chessBoard.getTile(i, j).isOccupied()) {return false;}
					j++;
				}
				return true;
			}
			else if ((x2 > x1) && (y2 < y1)) {
				j=y1-1;
				for (i=x1+1; i<x2; i++) {
					if (chessBoard.getTile(i, j).isOccupied()) {return false;}
					j--;
				}
				return true;
			}
			else if ((x1>x2) && (y2>y1)) {
				j = y1+1;
				for (i=x1-1; i>x2; i--) {
					if (chessBoard.getTile(i, j).isOccupied()) {return false;}
					j++;
				}
				return true;
			}
			else if ((x1 > x2) && (y1 > y2)) {
				j = y1-1;
				for (i=x1-1; i>x2; i--) {
					if (chessBoard.getTile(i, j).isOccupied()) {return false;}
					j--;
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean checkKnight(int x1, int y1, int x2, int y2, Board chessBoard){
		// Checking validity of move if selected piece is knight
		
		if (chessBoard.getTile(x2, y2).isOccupied()){
			if (chessBoard.getTile(x2, y2).getPiece().getColor() == Piece.WHITE) {return false;}
		}
		if ((Math.abs(x2-x1) == 2) && (Math.abs(y2-y1) == 1)) {
			return true;
		}
		else if ((Math.abs(x2-x1) == 1) && (Math.abs(y2-y1) == 2)) {
			return true;
		}
		return false;
	}
	
	public boolean checkQueen(int x1, int y1, int x2, int y2, Board chessBoard){
		// Checking validity of move if selected piece is queen
		
		boolean flag = checkRook(x1, y1, x2, y2, chessBoard);
		if (flag == true) {return true;}
		flag = checkBishop(x1, y1, x2, y2, chessBoard);
		if (flag == true) {return true;}
		
		return false;
	}
	
	public boolean checkKing(int x1, int y1, int x2, int y2, Board chessBoard){
		// Checking validity of move if selected piece is king
		
		if (chessBoard.getTile(x2,  y2).isOccupied()) {
			if (chessBoard.getTile(x2, y2).getPiece().getColor() == Piece.WHITE) {return false;}
		}
		if ((Math.abs(x1-x2)==1) || (Math.abs(y1-y2) == 1)) {
			return true;
		}
		return false;
	}
}