
public class Board {

	Cell[][] board = new Cell[9][8];
	
	public void generateBoard() {
	
		for (int i=0; i<9; i++) {
			
			if(i%2==0) {
				for(int x=0; x<7; x++) {
					board[i][x] = new Cell("color", i, x);
					System.out.println(board[i][x]);
				}
			}else {
				for(int x=0; x<8; x++) {
					board[i][x] = new Cell("color", i, x);
					System.out.println(board[i][x]);
				}
			}
		}
	}
}
