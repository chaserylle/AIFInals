/**
 * 
 */

/**
 * @author Chasey
 *
 */

import java.util.Scanner;
public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String playerID;
		String currentPlayer;
		Game G = new Game();
		Scanner kbd = new Scanner(System.in);
//		int choice;
		Board X = new Board();
		X.generateBoard();
		X.printBoard();
		
		System.out.println();
		
		int centerColumn;
		int centerRow;
		System.out.println("Enter the center of the initial tablue.");
		System.out.print("Enter the column number of the vertex: ");
		centerColumn = kbd.nextInt();
		System.out.print("Enter the row number of the vertex: ");
		centerRow = kbd.nextInt();
		
		X.setInitialState(centerColumn, centerRow);
		
		System.out.print("Who am I? (X or O): ");
		playerID = kbd.next();
		System.out.println();
		
		System.out.print("Who goes first? (X or O): ");
		currentPlayer = kbd.next();
		
		
		
		
//		boolean loop = true;
//		while(loop) {
//			System.out.println("----------------");
//			System.out.println("PROGRAM OPTIONS");
//			System.out.println("----------------");
//			System.out.println("1. Set initial state.");
//			System.out.println("2. Print board.");
//			System.out.println("3. Fyt me!");
//			System.out.println("0. Exit");
//			System.out.print("Enter Choice: ");
//			choice = kbd.nextInt();
//			
//			switch(choice){
//			
//			case(1): //set initial state
//				
//				System.out.print("Who am I? (X or O): ");
//				G.playerID = kbd.next();
//				System.out.println("Welcome player "+G.playerID);
//				break;
//				
//			case(2):
//				X.printBoard();
//				break;
//				
//			case(3):
//				boolean go = true;
//				System.out.print("Who goes first?(X or 0) ");
//				String first = kbd.next();
//				
//				break;
//				
//			case(0):
//				System.out.println("Goodbye!");
//				loop = false;
//				break;
//			}
//			System.out.println();
//		}
	}
	
	
	public void readOponentMove() {
		
	}
	


}
