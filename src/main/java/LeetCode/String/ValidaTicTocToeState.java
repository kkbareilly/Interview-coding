package LeetCode.String;

public class ValidaTicTocToeState {



    public static boolean valida(String board[]){

        int x=0;
        int o=0;
        boolean xWins=false;
        boolean oWins=false;
        for (int i=0;i<3;i++){
            for (char c:board[i].toCharArray()){
                if(c=='x')
                    x++;
                else
                    o++;
            }
            //Horizantol validation
            if (board[i].equals("xxx"))
                xWins=true;
            else if (board[i].equals("ooo"))
                oWins=true;

        //Vertical Validation
        StringBuilder vertical=new StringBuilder();
        vertical.append(board[0].charAt(i))
                .append(board[1].charAt(i))
                .append(board[2].charAt(i));
        if(vertical.toString().equals("xxx"))
            xWins=true;
        else if (vertical.toString().equals("ooo"))
            oWins=true;


   }
        //left Diagonal
        StringBuilder diag1=new StringBuilder();
        diag1.append(board[0].charAt(0))
                .append(board[1].charAt(1))
                .append(board[2].charAt(2));
        if(diag1.toString().equals("xxx"))
            xWins=true;
        else if (diag1.toString().equals("ooo"))
            oWins=true;

        //right diagonal
        StringBuilder diag2=new StringBuilder();
        diag2.append(board[0].charAt(2))
                .append(board[1].charAt(1))
                .append(board[2].charAt(0));
        if(diag2.toString().equals("xxx"))
            xWins=true;
        else if (diag2.toString().equals("ooo"))
            oWins=true;
        if(xWins)
            return !oWins && x-o==1;

        else if(oWins)
            return !xWins && x-o==0;
        return x>o && x-0>=1;
    }
}
