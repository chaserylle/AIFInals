
public class Board {

	Cell[][] board = new Cell[9][8];
	
	public void generateBoard() {
		
		for (int i=0; i<=8; i++) {
			if(i%2!=0) {
				for(int x=0; x<6; x++) {
					board[i][x] = new Cell("pink", x, i);
//					System.out.print(board[i][x].getColumn() + ":" + board[i][x].getRow() + "    ");
				}
			}else {
				for(int x=0; x<7; x++) {
					board[i][x] = new Cell("black", x, i);
//					System.out.print(board[i][x].getColumn() + ":" + board[i][x].getRow() + "    ");
				}
			}
			
			System.out.println();
		}
		
		printBoard();
		
	}
	
	public void printBoard() {
		int i;
		int j;
		int k;
		
		for(i=7; i>=0; i--) {
			for(j=0; j<9; j++) {
				if(board[j][i]!=null)
					System.out.print(board[j][i].getColumn() + ":" + board[j][i].getRow() + "    ");
				else
					System.out.print("       ");
			}
			System.out.println();
			System.out.println();
		}
	}
}
