package DynamicPrograming.bounded;

public class MaximumProfit {

    static int val[]={1,3,4,5};
    static int  wt[]={1,4,5,7};
    static int w=10;

  public static void main(String[] args) {

    System.out.println(maxProfit(val,wt,w,wt.length-1));
  }

    public static int maxProfit(int[]val,int wt[],int w,int n){
        if(n==0 || w==0)
            return 0;
        if(wt[n-1]<=w){
            return Math.max(val[n-1]+maxProfit(val,wt,w-wt[n-1],n-1),maxProfit(val,wt,w,n-1));
        }else if(wt[n-1]>w){
            return maxProfit(val,wt,w,n-1);
        }
          return 0;
    }
}
