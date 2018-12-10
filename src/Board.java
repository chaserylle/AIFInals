
public class Board {

	Cell[][] board = new Cell[9][8];
	
	public void generateBoard() {
	
//		for(int row=0; row<=7; row++) {
//			if(row<7) {
//				for(int column=0; column<8; column++) {
//					if(column%2==0 || column==0) {
//						board[row][column] = new Cell("set",row,column);
//					}
//				}
//				for(int column2=0; column2<7; column2++) {
//					if(column2%2!=0) {
//						board[row][column2] = new Cell("offset",row,column2);
//					}
//				}
//			}
//		}
//		
//		printBoard();
		
		for (int i=0; i<=8; i++) {
			if(i%2!=0) {
				for(int x=0; x<6; x++) {
					board[i][x] = new Cell("pink", x, i);
					System.out.print(board[i][x].getRow() + ":" + board[i][x].getColumn() + "    ");
				}
			}else {
				for(int x=0; x<7; x++) {
					board[i][x] = new Cell("black", x, i);
					System.out.print(board[i][x].getRow() + ":" + board[i][x].getColumn() + "    ");
				}
			}
			
			System.out.println();
		}
	}
	
	public void printBoard() {
//		for(int i=0; i<9; i++) {
//			System.out.print(board[i][0].getRow() + ":" + board[i][0].getColumn() + "	");
////			System.out.println();
//		}
	}
}
