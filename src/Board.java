import java.util.ArrayList;
/**
 * @author Chasey & Kyeongho
 *
 */
public class Board {

	Cell[][] board = new Cell[9][8];
	ArrayList<Cell> nextCells = new ArrayList<Cell>();
	
	public void generateBoard() {
		
		for (int i=0; i<=8; i++) {
			if(i%2!=0) {
				for(int x=0; x<6; x++) {
					board[i][x] = new Cell("_", x, i,true);
//					System.out.print(board[i][x].getColumn() + ":" + board[i][x].getRow() + "    ");
				}
			}else {
				for(int x=0; x<7; x++) {
					board[i][x] = new Cell("_", x, i,false);
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
		if(column%2==0) {
			board[column][row+1].setOccupied(top); //top
			board[column+1][row].setOccupied(bottom); //upper right
			board[column+1][row-1].setOccupied(top); //lower right
			board[column][row-1].setOccupied(bottom); //bottom
			board[column-1][row-1].setOccupied(top); // lower left
			board[column-1][row].setOccupied(bottom); // upper left
		}
		else {
			board[column][row+1].setOccupied(top); //top
			board[column+1][row+1].setOccupied(bottom); //upper right
			board[column+1][row].setOccupied(top); //lower right
			board[column][row-1].setOccupied(bottom); //bottom
			board[column-1][row].setOccupied(top); // lower left
			board[column-1][row+1].setOccupied(bottom); // upper left
		}
		
		printBoard();

	}
	
	public void insertOponentTile(int column, int row, String oponent , String playerID) {
		board[column][row].setOccupied(oponent);
		ArrayList<Cell> toChange = checkDirection(oponent, playerID, column, row);
		System.out.println(toChange.toString());
		for(int i=0; i<toChange.size(); i++) {
			board[toChange.get(i).getColumn()][toChange.get(i).getRow()].setOccupied(oponent);
		}
		
		
//		CellChain oponentMove = new CellChain(oponent, row, column, board[column][row].getUp(), null);
		
		printBoard();
	}
	
	
	public int[] check(String playerID, String oponentID) {
		ArrayList<Cell> flip = new ArrayList<Cell>();
		int least = 100;
		int[] nextMove = {100,100};
		int[] no = {100,100};
		int tempCol;
		int tempRow;
		
		ArrayList<Cell> upperLeft = new ArrayList<Cell>();
		ArrayList<Cell> lowerLeft = new ArrayList<Cell>();
		ArrayList<Cell> upperRight = new ArrayList<Cell>();
		ArrayList<Cell> lowerRight = new ArrayList<Cell>();
		ArrayList<Cell> bottom = new ArrayList<Cell>();
		ArrayList<Cell> top = new ArrayList<Cell>();
		
		boolean closed = false;
		for(int column = 0; column < 9; column++) {
			for(int row = 0; row < board[column].length; row++) {
				if(board[column][row]!=null) {
					if(board[column][row].getOccupied().equals(playerID)) {
//						System.out.println(board[column][row].getColumn() +":"+ board[column][row].getRow()); 
						
						//check upper right
						tempCol = column;
						tempRow = row;
						closed = false;
						while(!closed) {
							if(tempCol%2==0) {
								if(checkNeighbor(tempCol+1, tempRow, oponentID)) {
//									System.out.println("upper right: " + (tempCol+1) + ":" + (tempRow));
									upperRight.add(board[tempCol+1][tempRow]);
									tempCol = tempCol+1;
								}
								else if(checkNeighbor(tempCol+1, tempRow, "_") && upperRight.size()!=0) {
									System.out.println("valid move " + (tempCol+1) + ":" + (tempRow));
									if(upperRight.size()<=least) {
										least = upperRight.size();
										flip = upperRight;
										nextMove[0] =  tempCol+1;
										nextMove[1] = tempRow;
									}
									closed = true;
								}
								else {
									closed = true;
								}
							}else {
								if(checkNeighbor(tempCol+1, tempRow+1, oponentID)) {
//									System.out.println("upper right: " + (tempCol+1) + ":" + (tempRow+1));
									upperRight.add(board[tempCol+1][tempRow+1]);
									tempCol = tempCol+1;
									tempRow = tempRow+1;
								}
								else if(checkNeighbor(tempCol+1, tempRow+1, "_") && upperRight.size()!=0) {
									System.out.println("valid move " + (tempCol+1) + ":" + (tempRow+1));
									if(upperRight.size()<=least) {
										least = upperRight.size();
										flip = upperRight;
										nextMove[0] =  tempCol+1;
										nextMove[1] = tempRow+1;
									}
									closed = true;
								}
								else {
									closed = true;
								}
							}
						}
						
						//check lower right
						tempCol = column;
						tempRow = row;
						closed = false;
						while(!closed) {
							if(tempCol%2==0) {
								if(checkNeighbor(tempCol+1, tempRow-1, oponentID)) {
//									System.out.println("lower left: " + (tempCol+1) + ":" + (tempRow-1));
									lowerRight.add(board[tempCol+1][tempRow-1]);
									tempCol = tempCol+1;
									tempRow = tempRow-1;
								}
								else if(checkNeighbor(tempCol+1, tempRow-1, "_") && lowerRight.size()!=0 ) {
									System.out.println("valid move " + (tempCol+1) + ":" + (tempRow-1));
									if(lowerRight.size()<=least) {
										least = lowerRight.size();
										flip = lowerRight;
										nextMove[0] =  tempCol+1;
										nextMove[1] = tempRow-1;
									}
									closed = true;
								}
								else {
									closed = true;
								}
							}else {
								if(checkNeighbor(tempCol+1, tempRow, oponentID)) {
//									System.out.println("lower left: " + (tempCol+1) + ":" + (tempRow));
									lowerRight.add(board[tempCol+1][tempRow]);
									tempCol = tempCol+1;
								}
								else if(checkNeighbor(tempCol+1, tempRow, "_") && lowerRight.size()!=0) {
									System.out.println("valid move " + (tempCol+1) + ":" + (tempRow));
									if(lowerRight.size()<=least) {
										least = lowerRight.size();
										flip = lowerRight;
										nextMove[0] =  tempCol+1;
										nextMove[1] = tempRow;
									}
									closed = true;
								}
								else {
									closed = true;
								}
							}
						}
						
//						System.out.println("lower right: " + (lowerRight-1)); //delete later
						
						//check bottom
						tempCol = column;
						tempRow = row;
						closed = false;
						while(!closed) {
							if(checkNeighbor(tempCol, tempRow-1, oponentID)) {
//								System.out.println("bottom: " + (tempCol) + ":" + (tempRow-1));
								bottom.add(board[tempCol][tempRow-1]);
								tempRow = tempRow - 1;
							}
							else if(checkNeighbor(tempCol, tempRow-1, "_") && bottom.size()!=0) {
								System.out.println("valid move " + (tempCol) + ":" + (tempRow-1));
								if(bottom.size()<=least) {
									least = bottom.size();
									flip = bottom;
									nextMove[0] =  tempCol;
									nextMove[1] = tempRow-1;
								}
								closed = true;
							}
							else {
								closed = true;
							}
						}
						
						
//						System.out.println("bottom: " + (bottom-1)); //delete later
						
						//check lower left
						
						tempCol = column;
						tempRow = row;
						closed = false;
						while(!closed) {
							if(tempCol%2==0) {
								if(checkNeighbor(tempCol-1, tempRow-1, oponentID)) {
//									System.out.println("lower left: " + (tempCol-1) + ":" + (tempRow-1));
									lowerLeft.add(board[tempCol-1][tempRow-1]);
									tempCol = tempCol-1;
									tempRow = tempRow-1;
								}
								else if(checkNeighbor(tempCol-1, tempRow-1, "_") && lowerLeft.size()!=0) {
									System.out.println("valid move " + (tempCol-1) + ":" + (tempRow-1));
									if(lowerLeft.size()<=least) {
										least = lowerLeft.size();
										flip = lowerLeft;
										nextMove[0] =  tempCol-1;
										nextMove[1] = tempRow-1;
									}
									closed = true;
								}
								else {
									closed = true;
								}
							}else {
								if(checkNeighbor(tempCol-1, tempRow, oponentID)) {
//									System.out.println("lower left: " + (tempCol-1) + ":" + (tempRow));
									lowerLeft.add(board[tempCol-1][tempRow]);
									tempCol = tempCol-1;
								}
								else if(checkNeighbor(tempCol-1, tempRow, oponentID) && lowerLeft.size()!=0 ) {
									System.out.println("valid move " + (tempCol-1) + ":" + (tempRow));
									if(lowerLeft.size()<=least) {
										least = lowerLeft.size();
										flip = lowerLeft;
										nextMove[0] =  tempCol-1;
										nextMove[1] = tempRow;
									}
									closed = true;
								}
								else {
									closed = true;
								}
							}
						}
						
//						System.out.println("lowerLeft: " + (lowerLeft-1)); //delete later
						
						tempCol = column;
						tempRow = row;
						closed = false;
						//check upper left
						while(!closed) {
							
							if(tempCol%2==0) {
								if(checkNeighbor(tempCol-1, tempRow, oponentID)) {
//									System.out.println("upper left: " + (tempCol-1) + ":" + (tempRow));
									upperLeft.add(board[tempCol-1][tempRow]);
									tempCol = tempCol-1;
								}
								else if(checkNeighbor(tempCol-1, tempRow, "_") && upperLeft.size()!=0) {
									System.out.println("valid move " + (tempCol-1) + ":" + tempRow);
									if(upperLeft.size()<=least) {
										least = upperLeft.size();
										flip = upperLeft;
										nextMove[0] =  tempCol-1;
										nextMove[1] = tempRow;
									}
									closed = true;
								}
								else {
									closed = true;
								}
							}else {
								if(checkNeighbor(tempCol-1, tempRow+1, oponentID)) {
//									System.out.println("upper left: " + (tempCol-1) + ":" + (tempRow+1));
									upperLeft.add(board[tempCol-1][tempRow+1]);
									tempCol = tempCol-1;
									tempRow = tempRow+1;
								}
								else if(checkNeighbor(tempCol-1, tempRow+1, "_") && upperLeft.size()!=0) {
									System.out.println("valid move " + (tempCol-1) + ":" + (tempRow+1));
									if(upperLeft.size()<=least) {
										least = upperLeft.size();
										flip = upperLeft;
										nextMove[0] =  tempCol-1;
										nextMove[1] = tempRow+1;
									}
									closed = true;
								}
								else {
									closed = true;
								}
							}
						}
						
//						System.out.println("upperLeft: " + (upperLeft-1)); //delete later
						
						//check top
						tempCol = column;
						tempRow = row;
						closed = false;
						while(!closed) {
							if(checkNeighbor(tempCol, tempRow+1, oponentID)) {
//								System.out.println("top: " + (tempCol) + ":" + (tempRow+1));
								top.add(board[tempCol][tempRow+1]);
								tempRow = tempRow + 1;
							}
							else if(checkNeighbor(tempCol, tempRow+1, "_") && top.size()!=0) {
//								System.out.println("valid move " + (tempCol) + ":" + (tempRow+1));
								if(top.size()<=least) {
									least = top.size();
									flip = top;
									nextMove[0] =  tempCol;
									nextMove[1] = tempRow+1;
								}
								closed = true;
							}
							else {
								closed = true;
							}
						}
						
//						System.out.println("top: " + (top-1)); //delete later
					}
				}
			}
		}
		if(nextMove.equals(no)) {
			nextMove = null;
		}else {
//			System.out.println(flip.get(0));
			board[nextMove[0]][nextMove[1]].setOccupied(playerID);
			flipTiles(playerID, oponentID, flip);
			printBoard();
		}
		return nextMove;
	}
	
	//for one tile only
	public ArrayList<Cell> check(String playerID, String oponentID, int c, int r) {
		ArrayList<Cell> enemies = new ArrayList<Cell>();
		for(int column = 0; column < 9; column++) {
			for(int row = 0; row < board[column].length; row++) {
				if(board[column][row]!=null) {
					if(board[column][row].getOccupied().equals(playerID) && column==c && row==r) {
						System.out.println(board[column][row].getColumn() +":"+ board[column][row].getRow()); 
						
						//check upper right
						if(column%2==0) {
							if(checkNeighbor(column+1, row, oponentID)) {
								System.out.println("enemy: " + (column+1) + ":" + (row));
								enemies.add(board[column+1][row]);
							}
						}else {
							if(checkNeighbor(column+1, row+1, oponentID)) {
								System.out.println("enemy: " + (column+1) + ":" + (row+1));
								enemies.add(board[column+1][row+1]);
							}
						}
						
						//check lower right
						if(column%2==0) {
							if(checkNeighbor(column+1, row-1, oponentID)) {
								System.out.println("enemy: " + (column+1) + ":" + (row-1));
								enemies.add(board[column+1][row-1]);
							}
						}else {
							if(checkNeighbor(column+1, row, oponentID)) {
								System.out.println("enemy: " + (column+1) + ":" + (row));
								enemies.add(board[column+1][row]);
							}
						}
						
//						System.out.println("lower right: " + (lowerRight-1)); //delete later
						
						//check bottom
						if(checkNeighbor(column, row-1, oponentID)) {
							System.out.println("enemy: " + (column) + ":" + (row-1));
							enemies.add(board[column][row-1]);
						}
						
//						System.out.println("bottom: " + (bottom-1)); //delete later
						
						//check lower left
						if(column%2==0) {
							if(checkNeighbor(column-1, row-1, oponentID)) {
								System.out.println("enemy: " + (column-1) + ":" + (row-1));
								enemies.add(board[column-1][row-1]);
							}
						}else {
							if(checkNeighbor(column-1, row, oponentID)) {
								System.out.println("enemy: " + (column-1) + ":" + (row));
								enemies.add(board[column-1][row]);
							}
						}
						
//						System.out.println("lowerLeft: " + (lowerLeft-1)); //delete later
						
						//check upper left
						if(column%2==0) {
							if(checkNeighbor(column-1, row, oponentID)) {
								System.out.println("enemy: " + (column-1) + ":" + (row));
								enemies.add(board[column-1][row]);
							}
						}else {
							if(checkNeighbor(column-1, row+1, oponentID)) {
								System.out.println("enemy: " + (column-1) + ":" + (row+1));
								enemies.add(board[column-1][row]);
							}
						}
						
//						System.out.println("upperLeft: " + (upperLeft-1)); //delete later
						
						//check top
						if(checkNeighbor(column, row+1, oponentID)) {
							System.out.println("enemy: " + (column) + ":" + (row+1));
							enemies.add(board[column][row+1]);
						}
						
//						System.out.println("top: " + (top-1)); //delete later
					}
				}
			}
		}
		
		
		
		return enemies;
	}
	
	public ArrayList<Cell> checkDirection(String playerID, String oponentID, int c, int r){
		ArrayList<Cell> enemies = new ArrayList<Cell>();
		boolean closed;
		int tempCol;
		int tempRow;
		
		for(int column = 0; column < 9; column++) {
			for(int row = 0; row < board[column].length; row++) {
				if(board[column][row]!=null) {
					if(board[column][row].getOccupied().equals(playerID) && column==c && row==r) {
						
						//check upper right
						tempCol = column;
						tempRow = row;
						closed = false;
						while(!closed) {
							if(column%2==0) {
								if(checkNeighbor(tempCol+1, tempRow, oponentID)) {
									System.out.println("enemy: " + (tempCol+1) + ":" + (tempRow));
									tempCol = column+1;
									enemies.add(board[tempCol+1][tempRow]);
								}
								else if(checkNeighbor(tempCol+1, tempRow, playerID)) {
									closed = true;
								}
							}else {
								if(checkNeighbor(tempCol+1, tempRow+1, oponentID)) {
									System.out.println("enemy: " + (tempCol+1) + ":" + (tempRow+1));
									enemies.add(board[tempCol+1][tempRow+1]);
									tempCol = tempCol+1;
									tempRow = tempRow+1;
									}
								else if(checkNeighbor(tempCol+1, tempRow+1, playerID)) {
									closed = true;
								}
							}
						}
						
						//check lower right
						closed = false;
						while(!closed) {
							if(column%2==0) {
								if(checkNeighbor(column+1, row-1, oponentID)) {
									System.out.println("enemy: " + (column+1) + ":" + (row-1));
									enemies.add(board[column+1][row-1]);
								}
								else if(checkNeighbor(column+1, row-1, playerID)) {
									closed = true;
								}
							}else {
								if(checkNeighbor(column+1, row, oponentID)) {
									System.out.println("enemy: " + (column+1) + ":" + (row));
									enemies.add(board[column+1][row]);
								}
								else if(checkNeighbor(column+1, row, playerID)) {
									closed = true;
								}
							}
							closed = true;
						}
						
						//check bottom
						closed = false;
						while(!closed) {
							if(column%2==0) {
								if(checkNeighbor(column, row-1, oponentID)) {
									System.out.println("enemy: " + (column) + ":" + (row-1));
									enemies.add(board[column][row-1]);
								}
								else if(checkNeighbor(column, row-1, playerID)) {
									closed = true;
								}
							}
							closed = true;
							
						}
						
						//check top
						closed = false;
						while(!closed) {
							if(column%2==0) {
								if(checkNeighbor(column, row+1, oponentID)) {
									System.out.println("enemy: " + (column) + ":" + (row-1));
									enemies.add(board[column][row-1]);
								}
								else if(checkNeighbor(column, row+1, playerID)) {
									closed = true;
								}
							}
							
						}
						
						//check upper left
						closed = false;
						while(!closed) {
							if(column%2==0) {
								if(checkNeighbor(column-1, row, oponentID)) {
									System.out.println("enemy: " + (column-1) + ":" + (row));
									enemies.add(board[column-1][row]);
								}
								else if(checkNeighbor(column-1, row, playerID)) {
									closed = true;
								}
							}else {
								if(checkNeighbor(column-1, row+1, oponentID)) {
									System.out.println("enemy: " + (column-1) + ":" + (row+1));
									enemies.add(board[column-1][row+1]);
								}
								else if(checkNeighbor(column-1, row+1, playerID)) {
									closed = true;
								}
							}
							closed = true;
						}
						
						//check lower left
						closed = false;
						while(!closed) {
							if(column%2==0) {
								if(checkNeighbor(column-1, row-1, oponentID)) {
									System.out.println("enemy: " + (column+1) + ":" + (row));
									enemies.add(board[column-1][row-1]);
								}
								else if(checkNeighbor(column-1, row-1, playerID)) {
									closed = true;
								}
							}else {
								if(checkNeighbor(column-1, row, oponentID)) {
									System.out.println("enemy: " + (column-1) + ":" + (row));
									enemies.add(board[column-1][row]);
								}
								else if(checkNeighbor(column-1, row, playerID)) {
									closed = true;
								}
							}
							closed = true;
							
						}
						
					}
				}
			}
		}
		
		return enemies;
		
	}
	
	public boolean checkNeighbor(int column, int row, String id) {
		boolean occupied = false;
		try {
			if(board[column][row]!=null) {
				if(board[column][row].getOccupied().equals(id))
					occupied = true; 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return occupied;
	}
	
	public void flipTiles(String playerID, String opponentID, ArrayList<Cell> toFlip) {
		for(int i=0; i<toFlip.size(); i++) {
			board[toFlip.get(i).getColumn()][toFlip.get(i).getRow()].setOccupied(playerID);
		}
	}
	

	/**
	 * @param column
	 * @param row
	 * @param opponent_id
	 * 	where no of row is less than other cell - up
	 * 	where no of row is greater than other cell - down
	 *
	 * 	below is possible chains of cells
     *
	 * 	(upper or lower move)
	 * 	=> upper - y++ , lower - y--
	 * 	(upper right)
	 * 	=> if(up) x++ y++ if(down) x++
	 * 	(upper left)
	 * 	=> if(up) x-- y++ if(down) x--
	 * 	(lower right)
	 * 	=> if(up) x++  if(down) x++y--
     * 	(lower left)
     * 	=> if(up) x-- if(down) x-- y--
	 */
	public void fillNextCell(int column, int row , String opponent_id){
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