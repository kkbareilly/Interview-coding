package LeetCode.Leet150.dp.extra;

public class TopDownKnapShak {

    public int maxSum(int wt[],int val[],int w, int n){
        int dp[][]=new int[n+1][w+1];
        //column
        for(int i=0;i<w+1;i++){
            dp[0][i]=0;
        }
       // row
        for(int i=0;i<w+1;i++){
            dp[i][0]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(wt[i-1]<w){
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][w-wt[i-1]],dp[i-1][j]);
                }else
                  dp[i][j]=  dp[i-1][j];
            }
        }
        return dp[n][w];
    }
}
