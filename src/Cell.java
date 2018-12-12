
public class Cell {
	private String occupied; // can be null, or the id of the player occupying the cell
	private int column;
	private int row;
	private boolean up;//check whether the cell is upper in the hexed, if up true, if down false this is made to check the chain
	
	public Cell(String occupied, int row, int column, boolean up) {
		super();
		this.occupied = occupied;
		this.column = column;
		this.row = row;
		this.up = up;
	}
	
	public String getOccupied() {
		return occupied;
	}
	public void setOccupied(String occupied) {
		this.occupied = occupied;
	}
	public void setUp(boolean up){ this.up = up; }
	public boolean getUp(){ return up; }
	
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "Cell [occupied=" + occupied + ", column=" + column + ", row=" + row  + "]";
	}
	
}
