package DynamicPrograming.unbounded;

public class CuttingRod {


    public static void main(String[] args) {
       int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
       int  price [] = {1,5,8,9,10,17,17,20};
      int res= profit(length,price,length.length);
      System.out.println(res);
    }

    public static int  profit(int lenght[],int profit[],int N){

        int dp[][]=new int[lenght.length+1][lenght.length+1];

        for(int l=0;l<lenght.length+1;l++){
            for(int m=0;m<N+1;m++){
                if(l==0 || m==0)
                dp[l][m]=0;
            }
        }


        for(int i=1;i<=profit.length;i++){
            for(int j=1;j<=lenght.length;j++){
                if(lenght[i-1]<=j){
                    dp[i][j]=Math.max(profit[i-1]+dp[i][j-lenght[i-1]],dp[i-1][j]);
                }else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[profit.length][lenght.length];
    }
}
