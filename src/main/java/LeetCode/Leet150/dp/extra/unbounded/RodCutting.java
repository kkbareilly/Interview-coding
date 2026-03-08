package LeetCode.Leet150.dp.extra.unbounded;

public class RodCutting {



    public void rcutting(int[]c,int p[],int n){
         int dp[][]=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            dp[0][i]=0;
        }

        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
    }
}
