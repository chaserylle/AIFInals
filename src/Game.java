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
		boolean playtime =  true;
		int choice;
		String playerID;
		String oponentID;
		Game G = new Game();
		Scanner kbd = new Scanner(System.in);
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
		System.out.print("player (top of vertex): ");
		String top = kbd.next();
		System.out.print("player (below vertex): ");
		String bottom = kbd.next();
		
		X.setInitialState(centerColumn, centerRow, top, bottom);
		
		System.out.print("Who am I? (R or G): ");
		playerID = kbd.next();
		System.out.print("Oponent ID? (R or G): ");
		oponentID = kbd.next();
		System.out.println();
		
		while(playtime) {
			System.out.println("----OPTIONS---");
			System.out.println("1. insert oponent tile");
			System.out.println("2. next move");
			
			System.out.print("Choice: ");
			choice = kbd.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter column: ");
					int oponentColumn = kbd.nextInt();
					System.out.print("Enter row: ");
					int oponentRow = kbd.nextInt();
					X.insertOponentTile(oponentColumn, oponentRow, oponentID, playerID);
					break;
				case 2:
					int[] coordinates = X.check(playerID, oponentID);
					if(coordinates[0]==100) {
						System.out.println("invalid");
					}else {
						System.out.println("next move: " +coordinates[0] + ":" +coordinates[1]);
					}
					
//					X.insertOponentTile(coordinates[0], coordinates[1], playerID, oponentID);
					break;
			}
		}
		
		
		
//			if(currentPlayer.equals(playerID)) {
//				X.check(playerID, oponentID);
//				currentPlayer = oponentID;
//			}
//			else {
//				System.out.print("Enter column: ");
//				int oponentColumn = kbd.nextInt();
//				System.out.print("Enter row: ");
//				int oponentRow = kbd.nextInt();
//				X.insertOponentTile(oponentColumn, oponentRow, oponentID, playerID);
//				currentPlayer = playerID;
//				System.out.println(currentPlayer);
//			}
//			System.out.print("Continue (press 'y'): ");
//			playtime = kbd.next();
//		
		
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
	

}
