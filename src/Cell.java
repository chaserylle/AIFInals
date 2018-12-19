
public class Cell {
	private String occupied; // can be null, or the id of the player occupying the cell
	private byte column;
	private byte row;
	private boolean up;//check whether the cell is upper in the hexed, if up true, if down false this is made to check the chain
	
	public Cell(String occupied, byte row, byte column) {
		super();
		this.occupied = occupied;
		this.column = column;
		this.row = row;
		if(column%2==0){
			this.up =false;
		}else{
			this.up =true;
		}
	}
	
	public String getOccupied() {
		return occupied;
	}
	public void setOccupied(String occupied) {
		this.occupied = occupied;
	}
	public void setUp(boolean up){ this.up = up; }
	public boolean getUp(){ return up; }
	
	public byte getColumn() {
		return column;
	}
	public void setColumn(byte column) {
		this.column = column;
	}
	public byte getRow() {
		return row;
	}
	public void setRow(byte row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "Cell [occupied=" + occupied + ", column=" + column + ", row=" + row  + "]";
	}
	
}
