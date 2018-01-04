/**
 *  
 * @author Rishabh Dalal
 * 
 */

package chess.player;
import chess.Move;
import chess.Board;

public abstract class Player {

	protected boolean color;
	/**
	 * 
	 * @param color .. Player's color
	 *            
	 */
	public Player(boolean color) {
		this.color = color;
	}


	/**
	 * Function to prompt the player to make a move after the first move has
	 * already been made
	 * 
	 * @param b .. Board to parse
	 *            
	 * @return Selected move
	 */
	public Move getNextMove(Board b) {
		return null;
	}

	public boolean getColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}
}
