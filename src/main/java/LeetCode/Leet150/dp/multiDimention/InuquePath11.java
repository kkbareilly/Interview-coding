package LeetCode.Leet150.dp.multiDimention;

import java.util.Arrays;

public class InuquePath11 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int d[]:dp)
            Arrays.fill(d,-1);
        return uniquePath(obstacleGrid,0,0,dp);
    }

    public int uniquePath(int grid[][],int row,int col,int dp[][]){
        if(row<0|| col<0 || row==grid.length || col==grid[0].length || grid[row][col]==1)
            return 0;
        if(row==grid.length-1 && col==grid[0].length-1)
            return 1;
        if (dp[row][col]!=-1)
            return dp[row][col];
        dp[row][col]=uniquePath(grid,row+1,col,dp)+uniquePath(grid,row,col+1,dp);
        return dp[row][col];
    }

}
