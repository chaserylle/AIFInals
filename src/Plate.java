import java.util.ArrayList;

public class Plate {
    private ArrayList<Cell> cellsTaken = new ArrayList<>();
    private ArrayList<CellChain> chainsDetected = new ArrayList<>(10);
    private final byte ROW_MAX = 7;
    private final byte COLUMN_MAX = 8;

    public boolean setInitialState(String first,String second, byte row, byte column){
        try {
            colorCell(first, (byte) (row + 1), column);
            colorCell(second, (byte) (row - 1), column);
            if (column % 2 == 0) {//where (row,column).getUp() = false
                colorCell(second, row, (byte) (column + 1));
                colorCell(first, (byte) (row - 1), (byte) (column + 1));
                colorCell(first, (byte) (row - 1), (byte) (column - 1));
                colorCell(second, row, (byte) (column - 1));
            } else {//where (row,column).getUp() true;
                if(row >6)return false; // up cells must not have index over 6
                colorCell(second, (byte) (row + 1), (byte) (column + 1));
                colorCell(first, row, (byte) (column + 1));
                colorCell(first, row, (byte) (column - 1));
                colorCell(second, (byte) (row + 1), (byte) (column - 1));
            }
            printPlate();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Initial State build up process went wrong");
            return false;
        }
    }

    public boolean colorCell(String color,byte row,byte column){
        if(column<0 || row<0){ // if column or row is lower than 0
            System.out.println("NEGATIVE INPUT oN COLUMN OR ROW DETECTED!"); // return warning
            return false; // return false
        }
        if(column<=COLUMN_MAX) { // if column is lower or equal to maximum
            if ((column % 2 == 0 && row <= ROW_MAX)||(column % 2 == 1 && row < ROW_MAX)) { // if (up and row is lower or equal to maximum) or (down and row is lower the maximum)
                cellsTaken.add(new Cell(color, row, column)); // add the Cell made of given parameter
                printPlate();
                return true;// and return true
            } else {
                return false;//else return false
            }
        }
        return false;//any other situation, return false
    }

    public void printPlate(){
        boolean found = false;

        for(int row=ROW_MAX;row>=0;row--){
            for(int col=0;col<=COLUMN_MAX;col++){
                for(Cell cellular : cellsTaken){
                    if(cellular.getColumn()==col && cellular.getRow()==row){
                        System.out.print(" "+cellular.getOccupied());
                        found =true;
                    }
                }
                if(found==false){
                    if(col%2!=0&&row>6){
                        System.out.print("  ");
                    } else {
                        System.out.print(" " + "-");
                    }
                }
                found=false;
            }
            System.out.println(" "+row);
        }
        System.out.println(" 0 1 2 3 4 5 6 7 8");

    }

    public void findChain(){

    }






}
