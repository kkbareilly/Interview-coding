package LeetCode.Leet150.backTracking;

public class NQueen {
     int N=4;
    public boolean queenProblem(){
       int solr[][]=new int[N][N];

       if(!queenProblemUtil(0,solr)){
           return false;
       }
       printQueenPosition(solr);
       return true;
    }

    private boolean queenProblemUtil(int col, int[][] sol) {
        if(col>=N){
            return true;
        }
        for(int i=0;i<N;i++){
        if(isSafe(i,col,sol)){
            sol[i][col]=1;

            if(queenProblemUtil(col+1,sol)){
                return true;
            }
            sol[i][col]=0;
        }

        }
        return false;
    }

    private boolean isSafe(int row, int col, int[][] sol) {
        for(int i=col;i<N;i++ ){
            if(sol[row][i]==1)
                return false;
        }
        for(int i=row,j=col;i>=0 &&j>=0;i--,j--){
            if(sol[i][j]==1)
                return false;
        }

        for(int i=row,j=col;i<N &&j>=0;i++,j--){
            if(sol[i][j]==1)
                return false;
        }
        return true;
    }
    private void printQueenPosition(int[][]sol){
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if(sol[i][j]==1)
                    System.out.println(sol[i][j]);
            }}
    }
}
