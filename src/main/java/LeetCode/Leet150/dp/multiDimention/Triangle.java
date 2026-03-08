package LeetCode.Leet150.dp.multiDimention;

import java.util.Arrays;
import java.util.List;

public class Triangle {


    public int minimumTotal(List<List<Integer>> triangle) {

        int height=triangle.size();

        int dp[][]=new int[height+1][height+1];
        for(int level=height-1;level>=0;level--){
            for(int i=0;i<=level;i++){
                dp[level][i]=triangle.get(level).get(i)+Math.min(dp[level+1][i],dp[level+1][i+1]);
            }
        }
        return dp[0][0];
    }


    public int minimumTotals(List<List<Integer>> triangle)
    {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        return minPathSum(0,0,triangle,n,dp);
    }
    public static int minPathSum(int i,int j,List<List<Integer>> triangle,int n,int[][]dp)
    {
        if(dp[i][j]!=-1)return dp[i][j];
        if(i==n-1)return triangle.get(i).get(j);
        int down=triangle.get(i).get(j)+minPathSum(i+1,j,triangle,n,dp);
        int diag=triangle.get(i).get(j)+minPathSum(i+1,j+1,triangle,n,dp);
        return dp[i][j]=Math.min(down,diag);
    }
}
