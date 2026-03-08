package LeetCode.Leet150.dp.multiDimention;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
      int [][]dp=new int[grid.length][grid[0].length];
      for (int i=0;i<grid.length;i++){
          for (int j=0;j<grid[0].length;j++){
              dp[i][j]=-1;
          }

      }
      return   minCost(grid,0,0,dp);
    }

    public int minCost(int grid[][],int i,int j,int[][]dp){
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
            }
        if(i<0 || j<0 || i==grid.length || j==grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
         }
        return dp[i][j]=Math.min(minCost(grid,i+1,j,dp),minCost(grid,i,j+1,dp))+grid[i][j];
    }


    public int minPathSum1(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int [][]dp=new int[row][col];

        return   minCost1(grid,row-1,col-1,dp);
    }

    public int minCost1(int grid[][],int i,int j,int[][]dp){
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(i<0 || j<0){
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        return dp[i][j]=Math.min(minCost1(grid,i-1,j,dp),minCost1(grid,i,j-1,dp))+grid[i][j];
    }

}


