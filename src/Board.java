
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
	public void setInitialState(int column, int row, String top, String bottom) {
//		boolean valid = true;
		board[column][row+1].setOccupied(top); //top
		board[column+1][row+1].setOccupied(bottom); //upper right
		board[column+1][row].setOccupied(top); //lower right
		board[column][row-1].setOccupied(bottom); //bottom
		board[column-1][row].setOccupied(top); // lower left
		board[column-1][row+1].setOccupied(bottom); // upper left
		
		printBoard();

	}
	
	public void insertOponentTile(int column, int row, String oponent) {
		boolean closed = false;
		board[column][row].setOccupied(oponent);
		while(!closed) {
			
		}
		printBoard();
	}
	
	public void nextMove(String playerID, String oponentID) {
		int t = 1;
		int ur = 1;
		int top = 0;
		int bottom = 0;
		int upperRight = 0;
		int lowerRight = 0;
		int upperLeft = 0;
		int lowerRght = 0;
		
		int least = 100;
	
		int nextMoveColumn;
		int nextMoveRow;
		
		for(int column = 0; column < 9; column++) {
			for(int row = 0; row < board[column].length; row++) {
				if(board[column][row]!=null) {
					if(board[column][row].getOccupied().equals(playerID)) {
						System.out.println(board[column][row].getColumn() +":"+ board[column][row].getRow()); 
						
					}
				}
			}
		}
	}
	
	public boolean checkNeighbor(int column, int row, String id) {
		boolean occupied = false;
		if(board[column][row]!=null) {
			if(board[column][row].getOccupied().equals(id))
				occupied = true; 
		}
		return occupied;
	}
	
//	public int cellsToTheTop(int column, int row, String oponent) {
//		int cells = 0;
//		int max;
//		if(column%2!=0)
//			max = 6;
//		else
//			max = 7;
//		
//		for(int i=0; i<max; i++) {
//			if(checkTop(column, row+1, oponent)) 
//				cells++;
//		}
//		
//		return cells;
//	}
}
	


