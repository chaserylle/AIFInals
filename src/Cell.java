
public class Cell {
	private String occupied; // can be null, or the id of the player occupying the cell
	private int column;
	private int row;
	
	public Cell(String occupied, int column, int row) {
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
	
// may not be necessary
//	public Cell getTop() {
//		return top;
//	}
//	public void setTop(Cell top) {
//		this.top = top;
//	}
//	public Cell getUpperRight() {
//		return upperRight;
//	}
//	public void setUpperRight(Cell upperRight) {
//		this.upperRight = upperRight;
//	}
//	public Cell getLowerRight() {
//		return lowerRight;
//	}
//	public void setLowerRight(Cell lowerRight) {
//		this.lowerRight = lowerRight;
//	}
//	public Cell getBottom() {
//		return bottom;
//	}
//	public void setBottom(Cell bottom) {
//		this.bottom = bottom;
//	}
//	public Cell getLowerLeft() {
//		return lowerLeft;
//	}
//	public void setLowerLeft(Cell lowerLeft) {
//		this.lowerLeft = lowerLeft;
//	}
//	public Cell getUpperLeft() {
//		return upperLeft;
//	}
//	public void setUpperLeft(Cell upperLeft) {
//		this.upperLeft = upperLeft;
//	}

	@Override
	public String toString() {
		return "Cell [occupied=" + occupied + ", column=" + column + ", row=" + row  + "]";
	}
	
}
