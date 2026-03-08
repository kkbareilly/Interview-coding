package LeetCode.Leet150.dp.extra;

public class kanpshakMemorize {

    public static void main(String[] args){
       int wt[]={1,4,5,6};
       int val[]={5,3,7,8};
       int w=6;
        int dp[][]=new int[wt.length+1][w+1];
        sknpshak(wt,val,w,wt.length,dp);
    }

    public static int sknpshak(int wt[],int val[],int w,int n,int dp[][]){
        if(w==0||n==0)
                return 0;
        if(dp[n][w]!=-1){
            return dp[n][w];
        }
        if(wt[n-1]<w)
           return dp[n][w]=Math.max(val[n-1]+sknpshak(wt,val,w-wt[n-1],n-1,dp),sknpshak(wt,val,w-wt[n-1],n-1,dp));
        else
          return dp[n][w]=  sknpshak(wt,val,w-wt[n-1],n-1,dp);
    }
}
