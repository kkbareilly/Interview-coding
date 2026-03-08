package LeetCode.Leet150.matrix;

public class GameOfLife {

    public int[][] gameOfLife(int[][] board){
        int m=board.length;
        int n=board[0].length;
        int res[][]=new int[m][n];
        int dir[][]=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int count=0;
                for(int[] di:dir){
                    int p=i+di[0];
                    int q=j+di[1];
                    if(p>=0 &&p<m&&q>=0 && q<n&& (board[p][q])==1){
                        count++;
                    }
                }
                if(board[i][j]==1){
                    if(count==2 ||count==3){
                        res[i][j]=1;
                    }
                }else{
                    if(count==3){
                        res[i][j]=1;
                    }
                }
            }

        }
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                board[i][j]=res[i][j];
            }}
        return  board;
    }




    public int[][] gameOfLife2(int[][] board){
        int m=board.length;
        int n=board[0].length;
        int res[][]=new int[m][n];
        int dir[][]=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int count=0;
                for(int[] di:dir){
                    int p=i+di[0];
                    int q=j+di[1];
                    if(p>=0 &&p<m&&q>=0 && q<n&& (board[p][q]==1 ||board[p][q]==2)){
                        count++;
                    }
                }
                //alive 1 to dead 2
                if(board[i][j]==1){
                    if(count<2 ||count>3){
                        board[i][j]=2;
                    }
                }else{
                    if(count==3){
                        board[i][j]=3;
                    }
                }
            }

        }
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                board[i][j]%=2;
            }}
        return  board;
    }
}
