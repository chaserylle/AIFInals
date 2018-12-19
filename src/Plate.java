import java.util.ArrayList;
public class Plate {
    private ArrayList<Cell> cellsTaken;
    private final byte ROW_MAX = 8;
    private final byte COLUMN_MAX = 9;

    public boolean setInitialState(column ,byte column, byte row){
        if(column%2==0){//down
            colorCell(,column,row);
        }else{//up

        }
    }

    public boolean colorCell(String color,byte column,byte row){
        if(column<9 && row<8) {
            cellsTaken.add(new Cell(color, column, row));
            return true;
        }else{
            return false;
        }
    }



}
