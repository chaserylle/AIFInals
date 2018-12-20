public class CellChain extends Cell {
    private CellChain parent;
    private String direction;

    public CellChain(String occupied, byte row, byte column,CellChain parent){
        super(occupied,row,column);

        //if checkDirection returns true, assign parent and set Direction.
        if(checkDirection(this,parent)){
            this.parent = parent;
            findDirection(this);
        }
    }

    public String getDirection(){
        return direction;
    }

    public CellChain getParent(){
        return parent;
    }

    /**
     *  Directions are 4 kinds : Up UpRight DownRight Down DownLeft UpLeft.
     *  else null.
     *
     * @param cell the chellchain would be checked its direction.
     * @return String Direction
     */
    public String findDirection(CellChain cell){

        if(cell.getUp()==cell.getParent().getUp()){
            if(cell.getColumn()==cell.getParent().getColumn()){
                if(cell.getRow()==cell.getParent().getRow()+1)return "Up";
                if(cell.getRow()+1==cell.getParent().getRow())return "Down";
            }
        }//true-true, false-false

        if(cell.getParent().getUp()&&!cell.getUp()){
            if(cell.getRow()==cell.getParent().getRow()+1){
                if(cell.getColumn()==cell.getParent().getColumn()+1){
                    return "UpRight";
                }//x++
                if(cell.getColumn()+1==cell.getParent().getColumn()){
                    return "UpLeft";
                }//x--
            }//y++
            if(cell.getRow()==cell.getParent().getRow()){
                if(cell.getColumn()==cell.getParent().getColumn()+1){
                    return "DownRight";
                }//x++
                if(cell.getColumn()+1==cell.getParent().getColumn()){
                    return "DownLeft";
                }//x--
            }//y
        }//true->false

        if(!cell.getParent().getUp()&&cell.getUp()){
            if(cell.getRow()==cell.getParent().getRow()){
                if(cell.getColumn()==cell.getParent().getColumn()+1){
                    return "UpRight";
                }//x++
                if(cell.getColumn()+1==cell.getParent().getColumn()){
                    return "UpLeft";
                }//x--
            }//y
            if(cell.getRow()+1==cell.getParent().getRow()){
                if(cell.getColumn()==cell.getParent().getColumn()+1){
                    return "DownRight";
                }//x++
                if(cell.getColumn()+1==cell.getParent().getColumn()){
                    return "DownLeft";
                }//x--
            }//y--
        }//false->true
        this.parent = null;//other Directions are not allowed, so remove parent from cell.
        return null;// and set the direction null, now the cell is regarded as initial
    }



    private boolean checkDirection(CellChain cell,CellChain pcell){
            if (cell.getDirection().equals(pcell.getDirection())) return true;
            //if parent nominate and current have same direction, return true to find direction
            if (pcell.getDirection() == null) return true;
            //if parent nominate is initial state, return true to find direction.
            return false;//else, return false
    }

}
