import java.util.Scanner ;

public class theMain {
    static Scanner reader=new Scanner(System.in);

    public static void main(String[] args){
        try{
            run();
        }catch(Exception x){
            x.printStackTrace();
        }
    }

    static void run()throws Exception{
        Plate board=new Plate();

        //lI = [row,col]. playerX = [name,color]
        String[] player1=new String[2],player2 = new String[2];
        byte[] lI = new byte[2];

        boolean repeater_tillInit = false;
        do{
            System.out.print("\nPlayer 1 :");
            player1[0]= reader.next();
            System.out.print("\nplayer 2 :");
            player2[0]= reader.next();
            System.out.print("\nAssign color to "+player1[0]);
            player1[1]= reader.next();
            System.out.print("\nAssign color to "+player2[0]);
            player2[1]= reader.next();
            System.out.println("where should be the initial location?");
            System.out.print("Row :");
            lI[0] = reader.nextByte();
            System.out.print("\nColumn :");
            lI[1] = reader.nextByte();

            repeater_tillInit = board.setInitialState(player1[1],player2[1],lI[0],lI[1]);
        }while(!repeater_tillInit);

        repeater_tillInit = false;
        int choice;
        String selection;
        do{
            System.out.println(" 1.Assigning Color into Cell \n 2.Do the next Move \n choose one");
            switch(reader.nextInt()){
                case 1 :
                    System.out.print("which player's color?Choose :"+player1[0]+"-"+player1[1]+" or "+player2[0]+"-"+player2[1]+"\n");
                    selection = reader.next();
                    System.out.print("Row :");
                    lI[0] = reader.nextByte();
                    System.out.print("\nColumn : ");
                    lI[1] = reader.nextByte();
                    System.out.println();
                    if(selection.equals(player1[0])||selection.equals(player1[1]))board.colorCell(player1[1],lI[0],lI[1]);
                    if(selection.equals(player2[0])||selection.equals(player2[1]))board.colorCell(player2[1],lI[0],lI[1]);
                    board.findChain();
                    break;

                case 2 :
                    System.out.println("this function is still on development");
                    break;

                default: System.out.println("wrong input, try again :)");
            }
        }while(!repeater_tillInit);

    }

}
