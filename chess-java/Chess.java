/**
 * @author Rishabh Dalal
 *  
 */



public class Chess {
	
	public static void main(String[] args) {
		Board board = new Board();
		final int DEPTH = 3; // Depth for the search tree
		
		Player user = new User(Piece.WHITE);
		Player computer = new Comp(Piece.BLACK, DEPTH);
		
		int winner = play(user, computer, board);
			
		if(winner == 1)
			System.out.println("YOU win!!!");
		else if(winner == 0) {
			System.out.println("Its a draw");
		}
		else {System.out.println("I won");}
	}
	
	/** 1 .. user wins
	 *  0 .. draw
	 * -1 .. computer wins
	 */
	public static int play(Player usr, Player comp, Board b) {
		Move move;
		int result;
		int turn = 0;
		System.out.print("Initalizing. You are assigned as the white player (red for linux) which is represented ");
		System.out.println("by capital pieces.\n");
		System.out.println("Game starting...\n\n");
		while(true) {
			if(turn++ > 200) { 
				System.out.println("It seems that we have played for too long. I am tired. I give up.");
				return 0;
			}
			System.out.println(b);
			
			move = usr.getNextMove(b);
			result = b.makeMove(move);
			if(move == null && b.isCheck(usr.getColor())) // check and can't move
				return 1;
			if(move == null) // no check but can't move
				return 0;
			
			move = comp.getNextMove(b);
			if(move == null && b.isCheck(comp.getColor())) // check and can't move
				return 1;
			if(move == null) // no check but can't move
				return 0;
			
			result = b.makeMove(move);	
			System.out.println("I made my move: " + resolveChoice(move.getXOld()) + (move.getYOld()+1) + " " + resolveChoice(move.getXNew()) + (move.getYNew()+1) + "\n");
		} 
	}
	
	public static char resolveChoice(int a) {
		
		if (a ==0) {return 'a';}
		else if (a ==1) {return 'b';}
		else if (a ==2) {return 'c';}
		else if (a ==3) {return 'd';}
		else if (a ==4) {return 'e';}
		else if (a ==5) {return 'f';}
		else if (a ==6) {return 'g';}
		else {return 'h';}
	}

}