package LeetCode.Leet150.dp.d1;

public class CoinChange {

    int coinChanges(int[] coins,int amount){
        if (amount<1) return -1;

        int[]minCoinDp=new int[amount];

        for (int i=1;i<=amount;i++){
            minCoinDp[i]=Integer.MAX_VALUE;

            for(int coin:coins){
                if(coin<=i && minCoinDp[i-coin]!=Integer.MAX_VALUE){
                    minCoinDp[i]=Math.min(minCoinDp[i],i+minCoinDp[i-coin] );
                }
            }

        }
        if (minCoinDp[amount]==Integer.MAX_VALUE) return -1;

        return minCoinDp[amount];
    }


    public int coin(int[] a,int amout){

        int dp[][]=new int[a.length+1][amout+1];

        for(int i=0;i<a.length;i++){
            for(int j=0;j<amout;j++){
                if(i==0){
                    dp[i][j]=0;

                }
                if(j==0){
                    dp[i][j]=Integer.MAX_VALUE;

                }

            }
        }
        for(int i=1;i<a.length;i++){
            for(int j=1;j<amout;j++){
                if(a[i-1]<=j){
                    dp[i][j]=Math.min(1+dp[i][j-a[i-1]],dp[i-1][j]);
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }}
        return dp[a.length-1][amout-1];
    }
}

