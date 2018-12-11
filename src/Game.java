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
		Scanner kbd = new Scanner(System.in);
		int choice;
		Board X = new Board();
		
		boolean loop = true;
		while(loop) {
			System.out.println("----------------");
			System.out.println("PROGRAM OPTIONS");
			System.out.println("----------------");
			System.out.println("1. Set initial state.");
			System.out.println("2. Print board.");
			System.out.println("0. Exit");
			System.out.print("Enter Choice: ");
			choice = kbd.nextInt();
			
			switch(choice){
			
			case(1): //set initial state
				int centerColumn;
				int centerRow;
				System.out.println("Enter the center of the initial tablue.");
				System.out.print("Enter the column number of the vertex: ");
				centerColumn = kbd.nextInt();
				System.out.print("Enter the row number of the vertex: ");
				centerRow = kbd.nextInt();
				break;
				
			case(2):
				X.generateBoard();
				break;
				
			case(0):
				System.out.println("Goodbye!");
				loop = false;
				break;
			}
			System.out.println();
		}
	}
	

}
