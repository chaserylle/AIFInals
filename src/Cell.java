
public class Cell {
	private String occupied; // can be null, or the id of the player occupying the cell
	private int column;
	private int row;
	
	public Cell(String occupied, int row, int column) {
		super();
		this.occupied = occupied;
		this.column = column;
		this.row = row;
	}
	
	public String getOccupied() {
		return occupied;
	}
	public void setOccupied(String occupied) {
		this.occupied = occupied;
	}
	
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
