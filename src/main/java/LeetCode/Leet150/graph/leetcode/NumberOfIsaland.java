package LeetCode.Leet150.graph.leetcode;

public class NumberOfIsaland {

    public int isaland(int mat[][]){
        int row=mat.length;
        int col=mat[0].length;
        int numberOfIsaland=0;
        for(int i=0;i<row-1;i++){
           for( int j=0;j<col-1;j++){
               if(mat[i][j]==1){
                   numberOfIsaland+=dfs(mat,i,j);
               }
           }
        }
        return numberOfIsaland;
    }

    public int dfs(int mat[][],int i,int j){
        if(i<0||i>mat.length || j<0 || j>mat[0].length||mat[i][j]==0)
            return 0;
        mat[i][j]=0;
        dfs(mat,i+1,j);
        dfs(mat,i-1,j);
        dfs(mat,i,j+1);
        dfs(mat,i,j-1);
        return 1;
    }
}
