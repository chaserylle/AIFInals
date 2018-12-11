
/**
 * @author Chasey
 *
 */
public class Board {

	Cell[][] board = new Cell[9][8];
	
	public void generateBoard() {
		
		for (int i=0; i<=8; i++) {
			if(i%2!=0) {
				for(int x=0; x<6; x++) {
					board[i][x] = new Cell("_", x, i);
//					System.out.print(board[i][x].getColumn() + ":" + board[i][x].getRow() + "    ");
				}
			}else {
				for(int x=0; x<7; x++) {
					board[i][x] = new Cell("_", x, i);
//					System.out.print(board[i][x].getColumn() + ":" + board[i][x].getRow() + "    ");
				}
			}
			
			System.out.println();
		}
		
//		printBoard();
		
	}
	
	/**
	 * prints the board
	 */
	public void printBoard() {
		int i;
		int j;
		int k;
		
		//had to separately print first row because it does not align.
		System.out.print(board[0][6].getOccupied() + "           ");
		System.out.print(board[2][6].getOccupied() + "           ");
		System.out.print(board[4][6].getOccupied() + "           ");
		System.out.print(board[6][6].getOccupied() + "           ");
		System.out.print(board[8][6].getOccupied() + "           ");
		System.out.println();
		
		for(i=5; i>=0; i--) {
			for(j=0; j<9; j++) {
				if(board[j][i]!=null)
					if(j%2!=0) {
						System.out.print(board[j][i].getOccupied() + "    ");
					}
				else
					System.out.print("       ");
			}
			System.out.println();
			for(j=0; j<9; j++) {
				if(board[j][i]!=null)
					if(j%2==0) {
						System.out.print(board[j][i].getOccupied() + "    ");
					}
				else
					System.out.print("       ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	/**
	 * @param column
	 * @param row
	 * 
	 * sets the initial state of the board
	 * 6 chips around (column,row) with alternating chips
	 * top, upper right, lower right, bottom, lower left and upper left.
	 */
	public void setInitialState(int column, int row) {
//		boolean valid = true;
		board[column][row+1].setOccupied("X"); //top
		board[column+1][row+1].setOccupied("O"); //upper right
		board[column+1][row].setOccupied("X"); //lower right
		board[column][row-1].setOccupied("O"); //bottom
		board[column-1][row].setOccupied("X"); // lower left
		board[column-1][row+1].setOccupied("O"); // upper left
		
		printBoard();
		
	}
	
	public void nextMove(String playerID) {
		for(int column = 0; column < board[column].length; column++) {
			for(int row = 0; row < board[column].length; row++) {
				if(board[column][row].getOccupied().equals(playerID)) {
					System.out.println(board[column][row].getColumn() +":"+ board[column][row].getRow()); 
				}
			}
		}
	}
	
}
