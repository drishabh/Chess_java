# Chess_java

1. A command line chess game created in java. It is both user Vs computer or user Vs user. It provides all the chess functionalities like
castling, replacing pawn with other piece if it reaches to the other side, blocking any other user move if it is in the state of check, etc.
In Windows or cmd, the user is represented by pieces of capital letters on the lower side. In linux, the user is represented by red color
pieces while the computer is represented by blue color in case of computer Vs user setting. 
  
2. The AI uses alpha beta pruning using minimax algorithm. The depth can be manually set, which now is set to 4. The algorithm is fairly fast
and intelligent. The implementation uses threads to work in parallel to decrease run-time.
 
3. User input is validated before making the move on the board. For example, pawn can only move one or two steps in the forward direction, 
only if the new tile is either empty or occupied by other player's piece.

4. ConsoleColor class is used to print the pieces on the console in linux using ANSI codes. THe available colors are blue, red, yellow, black,
green in several different ways, eg. regular, bold, high intensity, etc.
