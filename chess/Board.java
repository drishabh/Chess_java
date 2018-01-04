/**
 * @author Rishabh Dalal
 *
 */

package chess;
import chess.pieces.*;
import chess.Tile;
import java.util.ArrayList;

public class Board {
	public static final int a=0, b=1, c=2, d=3, e=4, f=5, g=6, h=7;
	
	private Tile[][] tiles;
	/**	  
	 * P=pawn, K=king, Q=queen, R=rook, N=knight, B=Bishop
	 * Uppercase is white
	 */
	
	public Board(Tile[][] tiles) {
		this.tiles = tiles;
	}

	/**
	 * 
	 */
	public Board() {
		// initialize board
		boolean color = Piece.WHITE;
		tiles = new Tile[8][8];
		tiles[a][1-1] = new Tile(new Rook(color));
		tiles[b][1-1] = new Tile(new Knight(color));
		tiles[c][1-1] = new Tile(new Bishop(color));
		tiles[d][1-1] = new Tile(new Queen(color));
		tiles[e][1-1] = new Tile(new King(color));
		tiles[f][1-1] = new Tile(new Bishop(color));
		tiles[g][1-1] = new Tile(new Knight(color));
		tiles[h][1-1] = new Tile(new Rook(color));
		
		for(int i = 0; i < 8; i++) {
			tiles[i][2-1] = new Tile(new Pawn(color));
		}
		
		for(int i = 2; i < 7; i++) {
			for(int j = 0; j < 8; j++) {
				tiles[j][i] = new Tile();
			}
		}
		
		color = Piece.BLACK;
		tiles[a][8-1] = new Tile(new Rook(color));
		tiles[b][8-1] = new Tile(new Knight(color));
		tiles[c][8-1] = new Tile(new Bishop(color));
		tiles[d][8-1] = new Tile(new Queen(color));
		tiles[e][8-1] = new Tile(new King(color));
		tiles[f][8-1] = new Tile(new Bishop(color));
		tiles[g][8-1] = new Tile(new Knight(color));
		tiles[h][8-1] = new Tile(new Rook(color));
		
		for(int i = 0; i < 8; i++) {
			tiles[i][7-1] = new Tile(new Pawn(color));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board b = new Board();
		System.out.println(b);
	}
	
	public String toString() {
		String str = "";
		for(int i = 7; i >= 0; i--) {
			str += (i+1) + "  ";
			for(int j = 0; j < 8; j++) {
				str += tiles[j][i] + " ";
			}
			str += "\n";
		}
		
		str += "\n   a b c d e f g h\n";
		
		return str;
	}
	
	public ArrayList<Move> getAllPossibleMoves(boolean color) {
		return getAllPossibleMoves(color, true);
	}
	
	
	/**
	 * Checks if player color is under check
	 * 
	 * @param color
	 * @return
	 */
	public boolean isCheck(boolean color) {
		int x = -1, y = -1;
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++) {
				if(tiles[i][j].isOccupied() && 
						tiles[i][j].getPiece().getColor() == color &&
						tiles[i][j].getPiece().toString().equalsIgnoreCase("K")) {
					x = i; y = j;
				}
			}
		
		// check a move if after making this move the king can be killed (moving into check)
		ArrayList<Move> opponentMoves = getAllPossibleMoves(!color, false);
		
		// check all opponent moves if they kill king (opponent moves in next round)
		for(int j = 0; j < opponentMoves.size(); j++) {
			if(opponentMoves.get(j).getXNew() == x && opponentMoves.get(j).getYNew() == y)
				return true;
		}
		
		return false;	
	}
	
	/**
	 * Checks if player color is under check
	 * 
	 * @param color
	 * @return
	 */
	public boolean isCheckAfter(boolean color, ArrayList<Move> moves) {
		
		Tile[][] newTiles = getTilesAfter(moves);
		
		int x = -1, y = -1;
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++) {
				if(newTiles[i][j].isOccupied() && 
						newTiles[i][j].getPiece().getColor() == color &&
						newTiles[i][j].getPiece().toString().equalsIgnoreCase("K")) {
					x = i; y = j;
				}
			}
		
		// check a move if after making this move the king can be killed (moving into check)
		ArrayList<Move> opponentMoves = getAfterMoves(!color, moves, false);
		
		// check all opponent moves if they kill king (opponent moves in next round)
		for(int j = 0; j < opponentMoves.size(); j++) {
			if(opponentMoves.get(j).getXNew() == x && opponentMoves.get(j).getYNew() == y)
				return true;
		}
		
		return false;	
	}
	
	public ArrayList<Move> getAllPossibleMoves(boolean color, boolean checkCheck) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++) {
				if(tiles[i][j].isOccupied() && 
						tiles[i][j].getPiece().getColor() == color) {
					moves.addAll(tiles[i][j].getPiece().getAllPossibleMoves(this, i, j));
				}
			}
		
		// check if move is valid (must not be check after move) and throw away erroneous moves
		if(checkCheck) {
			// find king (of correct color)
			int x = -1, y = -1;
			for(int i = 0; i < 8; i++)
				for(int j = 0; j < 8; j++) {
					if(tiles[i][j].isOccupied() && 
							tiles[i][j].getPiece().getColor() == color &&
							tiles[i][j].getPiece().toString().equalsIgnoreCase("K")) {
						x = i; y = j;
					}
				}
			
			ArrayList<Move> removeThese = new ArrayList<Move>();
			for(int i = 0; i < moves.size(); i++) {
				// check a move if after making this move the king can be killed (moving into check)
				ArrayList<Move> checkThis = new ArrayList<Move>(moves.subList(i, i+1));
				ArrayList<Move> opponentMoves = getAfterMoves(!color, checkThis, false);
				
				int xUpdated = x, yUpdated = y;
				if(checkThis.get(0).getXOld() == x && checkThis.get(0).getYOld() == y) { // get updated king position
					xUpdated = checkThis.get(0).getXNew();
					yUpdated = checkThis.get(0).getYNew();
				}
				
				// check all opponent moves if they kill king (opponent moves in next round)
				for(int j = 0; j < opponentMoves.size(); j++) {
					if(opponentMoves.get(j).getXNew() == xUpdated && opponentMoves.get(j).getYNew() == yUpdated)
						removeThese.add(checkThis.get(0));
				}
			}
			
			moves.removeAll(removeThese); // remove invalid moves
		}
		
		return moves;
	}
	
	public ArrayList<Move> getAfterMoves(boolean color, ArrayList<Move> moves) {
		return getAfterMoves(color, moves, true);
	}
	
	public ArrayList<Move> getAfterMoves(boolean color, ArrayList<Move> moves, boolean checkCheck) {
		
		Tile[][] temp = new Tile[8][8];
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				temp[x][y] = new Tile(this.tiles[x][y]);
			}
		}
		
		Board b = new Board(temp);

		for(int i = 0; i < moves.size(); i++)
			b.makeMove(moves.get(i));
		
		ArrayList<Move> futureMoves = b.getAllPossibleMoves(color, checkCheck);
		
		return futureMoves;
	}
	
	public Tile[][] getTilesAfter(ArrayList<Move> moves) {
		
		Tile[][] temp = new Tile[8][8];
		for (int y = 0; y < 8; y++) {
			for (int i = 0; i < 8; i++) {
				temp[i][y] = new Tile(this.tiles[i][y]);
			}
		}
		
		Board b = new Board(temp);

		for(int i = 0; i < moves.size(); i++)
			b.makeMove(moves.get(i));
		
		Tile[][] temp2 = new Tile[8][8];
		for (int y = 0; y < 8; y++) {
			for (int i = 0; i < 8; i++) {
				temp2[i][y] = new Tile(b.getTile(i, y));
			}
		}
		
		return temp2;
	}
	
	/**
	 * @param Move m
	 * @return -1 .. black wins
	 * 			1 .. white wins
	 * 			0 .. game continues
	 */
	public int makeMove(Move m) {
		Tile oldTile = tiles[m.getXOld()][m.getYOld()];
				
		tiles[m.getXNew()][m.getYNew()] = tiles[m.getXOld()][m.getYOld()];
		tiles[m.getXOld()][m.getYOld()] = new Tile();
		
		if(m.isCastling()) {
			if(m.getXNew() == g && m.getYNew() == 1-1) {
				tiles[f][1-1] = tiles[h][1-1];
				tiles[h][1-1] = new Tile();
			}
			if(m.getXNew() == c && m.getYNew() == 1-1) {
				tiles[d][1-1] = tiles[a][1-1];
				tiles[a][1-1] = new Tile();			
			}
			if(m.getXNew() == g && m.getYNew() == 8-1) {
				tiles[f][8-1] = tiles[h][8-1];
				tiles[h][8-1] = new Tile();
			}
			if(m.getXNew() == c && m.getYNew() == 8-1) {
				tiles[d][8-1] = tiles[a][8-1];
				tiles[a][8-1] = new Tile();	
			}
		}
		
		// if pawn is at top
		if(oldTile.getPiece().toString().equals("P") && m.getYNew() == 8-1)
			tiles[m.getXNew()][m.getYNew()] = new Tile(new Queen(Piece.WHITE));
		
		if(oldTile.getPiece().toString().equals("p") && m.getYNew() == 1-1)
			tiles[m.getXNew()][m.getYNew()] = new Tile(new Queen(Piece.BLACK));
		
		return 0;
	}
	
	public Tile getTile(int i, int j) {
		return tiles[i][j];
	}

}
