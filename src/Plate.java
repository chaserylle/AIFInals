import java.util.ArrayList;
public class Plate {
    private ArrayList<Cell> cellsTaken;
    private ArrayList<CellChain> chainsDetected;
    private final byte ROW_MAX = 7;
    private final byte COLUMN_MAX = 8;

    public boolean setInitialState(String first,String second,byte column, byte row){
        try {
            colorCell(first, column, (byte) (row + 1));
            colorCell(second, column, (byte) (row - 1));
            if (column % 2 == 0) {//where (column,row).getUp() = false
                colorCell(second, (byte) (column + 1), row);
                colorCell(first, (byte) (column + 1), (byte) (row - 1));
                colorCell(first, (byte) (column - 1), (byte) (row - 1));
                colorCell(second, (byte) (column - 1), row);
            } else {//where (column,row).getUp() true;
                if(row >6)return false; // up cells must not have index over 6
                colorCell(second, (byte) (column + 1), (byte) (row + 1));
                colorCell(first, (byte) (column + 1), row);
                colorCell(first, (byte) (column - 1), row);
                colorCell(second, (byte) (column - 1), (byte) (row + 1));
            }
            printPlate();
            return true;
        } catch (Exception e){
            System.out.println("Initial State build up process went wrong");
            return false;
        }
    }

    public boolean colorCell(String color,byte column,byte row){
        if(column<0 || row<0){ // if column or row is lower than 0
            System.out.println("NEGATIVE INPUT oN COLUMN OR ROW DETECTED!"); // return warning
            return false; // return false
        }
        if(column<=COLUMN_MAX) { // if column is lower or equal to maximum
            if ((column % 2 == 0 && row <= ROW_MAX)||(column % 2 == 1 && row < ROW_MAX)) { // if (up and row is lower or equal to maximum) or (down and row is lower the maximum)
                cellsTaken.add(new Cell(color, column, row)); // add the Cell made of given parameter
                return true;// and return true
            } else {
                return false;//else return false
            }
        }
        return false;//any other situation, return false
    }

    public void printPlate(){
        for(int row=ROW_MAX;row>-1;row--){
            for(int col=0;col<=COLUMN_MAX;row++){
                for(Cell cellular : cellsTaken){
                    if(cellular.getColumn()==col && cellular.getRow()==row){
                        System.out.print(" "+cellular.getOccupied());
                    }else{
                        System.out.print(" "+"-");
                    }
                }
            }
        }
    }

    public void findChain(Cell cell){
        for(Cell i: cellsTaken) {//all cell taken will get measured firstly
                 chainsDetected.add(new CellChain(i.getOccupied(),i.getRow(),i.getColumn(),null));//adding one by one
        }

        for(CellChain i : chainsDetected){
            for(Cell j : cellsTaken){
                chainsDetected.add(new CellChain(j.getOccupied(),i.getRow(),i.getColumn(),i));
            }
            chainsDetected.remove(i);
        }

    }



}
