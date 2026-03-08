package LeetCode.Leet150.dp.extra;

public class EqualSumPartion {
    public static void main(String[] args){
        int a[]={1,4,6,8,5};
        int sum=0;
        for(int v:a){
            sum+=v;
        }
        if(sum%2==0){
          equalSum(a,sum/2,a.length);
        }else{
            System.out.println("Equal Partion is not possible");
        }
    }

    public static boolean equalSum(int a[],int w,int n){
        boolean dp[][]=new boolean[n+1][w+1];
        for(int i=0;i<w+1;i++){
            dp[0][i]=false;
        }
        for(int i=0;i<w+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(a[i-1]<j){
                    dp[i][j]=dp[i-1][j-a[i-1]]||dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }


}
