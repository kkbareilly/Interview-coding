package LeetCode.Leet150.dp.extra;

public class CountOfSubsetSum {


    public int countsubSet(int mat[],int w){
        int dp[][]=new int[mat.length+1][w+1];
        for(int i=0;i<w+1;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<w+1;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<mat.length+1;i++){
            for(int j=1;j<w+1;j++){
                if(mat[i-1]<=j){
                    dp[i][j]=dp[i-1][j-mat[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[mat.length][w];
    }
}
