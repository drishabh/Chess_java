/**
 * @author Rishabh Dalal
 *
 */

package chess.player;
import chess.Move;

import chess.Board;
import chess.player.Player;
import chess.chess_ai.*;

public class Comp extends Player {
	MinimaxAI minimax_ai;
	
	/**
	 * @param color
	 */
	public Comp(boolean color, int maxDepth) {
		super(color);
		minimax_ai = new MinimaxAI(color, maxDepth);
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
		Move move = minimax_ai.decision(b);
		return move;
	}

}
