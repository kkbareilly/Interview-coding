package LeetCode.Arrays;

public class UniquePath2 {

public static int  path=0;
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0]==1){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp= new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //first row & column
                if(i==0 || j==0){
                    //its prev cell was bstacles or current cell
                    if(grid[i][j]==1 || (i!=0 && grid[i-1][j]==0) || (j!=0 && grid[i][j-1]==0)){
                        grid[i][j]=0;
                    }else {
                        grid[i][j]=1;
                    }
                }else {
// all other rows
                if(grid[i][j]==1){
                    grid[i][j]=0;
                }else {
                    grid[i][j]=grid[i-1][j]+grid[i][j-1];
                }
                }
            }
        }

       return grid[m-1][n-1];
    }
    public  static int unique2(int grid[][]){
        uniquePath(grid,0,0);
        return path;
    }
    public static void uniquePath(int mat[][],int r,int c) {

        if(r<0 ||c<0 || r==mat.length-1 || c==mat[0].length-1 || mat[r][c]==1)
            return ;
        if (r == mat.length - 1 && c == mat[0].length - 1) {
            path++;
            return;
        }
        uniquePath(mat,r,c+1);
        uniquePath(mat,r+1,c);
    }
    public static int unique(int [][]obstacleGrid){
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        boolean flag=false;
        for(int i=0;i<n;i++){
            if(flag || obstacleGrid[0][i]==1){
                dp[0][i]=0;
                flag=true;
            }else
                dp[0][i]=1;
        }
        for(int i=0;i<m;i++){
            if(flag || obstacleGrid[i][0]==1){
                dp[i][0]=0;
                flag=true;
            }else
                dp[i][0]=1;
        }
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1)
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    };



}
