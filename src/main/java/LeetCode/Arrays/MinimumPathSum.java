package LeetCode.Arrays;
/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

        Note: You can only move either down or right at any point in time.*/
public class MinimumPathSum {
  public static void main(String[] args) {
      int grid[][]={{1,3,1},{1,5,1},{4,2,1}};
      int g[][]= {{1,2,3},{4,5,6}};
    System.out.println(minimum(g));
    System.out.println(minPathSum(grid));
    //
  }

    public static int minimum(int grid[][]){
        if(grid==null ||grid.length==0 )
            return 0;
        int dp[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                dp[i][i]+=grid[i][j];
                if(i>0 && j>0){
                    dp[i][j]+=Math.min(dp[i-1][j],dp[i][j-1]);
                }else  if(i>0){
                    dp[i][j]+=dp[i-1][j];
                }else  if(j>0){
                    dp[i][j]+=dp[i][j-1];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length-1,n = grid[0].length-1;
        int[][] path = new int[m+1][n+1];
        path[m][n] = grid[m][n];
        for(int i = m;i>=0;i--){
            for(int j=n;j>=0;j--){
                //if there are two possible paths ahead chose the lesser costly of the two paths
                if(i+1<=m && j+1<=n){
                    int c1 = grid[i][j],c2 = c1;
                    c1 += path[i+1][j];
                    c2 += path[i][j+1];
                    path[i][j] = Math.min(c1,c2);
                }else if(i+1 <= m)
                    path[i][j] = grid[i][j]+path[i+1][j];
                else if(j+1 <= n)
                    path[i][j] = grid[i][j]+path[i][j+1];
            }
        }
        return path[0][0];
    }
}
