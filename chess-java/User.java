/**
 * @author Rishabh Dalal
 *
 */

import java.util.Scanner;

public class User extends Player {
	
	public User(boolean color) {
		super(color);
	}

	/**
	 * Function to prompt the player to make a move after the first move has
	 * already been made
	 * 
	 * @param b
	 *            the board to parse
	 * @return the selected move
	 */
	public Move getNextMove(Board b) {
		Validity valid = new Validity();
		boolean flag = false;
		int x_1=0, x_2=0, y_1=0, y_2=0;
		
		while (flag == false) {
			System.out.print("Enter the positions of piece you want to move (a4 b2): ");
			String[] userChoice = takeInput();
			
			char x1 = userChoice[0].charAt(0);
			char y1 = userChoice[0].charAt(1);
			char x2 = userChoice[1].charAt(0);
			char y2 = userChoice[1].charAt(1);
			
			x_1 = understandInput(x1);
			x_2 = understandInput(x2);
			
			y_1 = Character.getNumericValue(y1)-1;
			y_2 = Character.getNumericValue(y2)-1;
			flag = valid.isValid(x_1, y_1, x_2, y_2, b);
			if (flag == false) {System.out.println("Please enter valid move");}
		}
		
		Move userMove = new Move(x_1, y_1, x_2, y_2);
		return userMove;
	}
	
	public static String[] takeInput() {
		// Taking input for each move of the user
		
		Scanner consoleInput = new Scanner(System.in);
		String uInput = consoleInput.nextLine();
		uInput = uInput.replace("\n", "").replace("\r", "");
		String[] user = uInput.split(" ");

		return user;
	}
	
	public static int understandInput(char a) {
		if (a == 'a') {return 0;}
		else if (a == 'b') {return 1;}
		else if (a == 'c') {return 2;}
		else if (a == 'd') {return 3;}
		else if (a == 'e') {return 4;}
		else if (a == 'f') {return 5;}
		else if (a == 'g') {return 6;}
		else {return 7;}
	}

}