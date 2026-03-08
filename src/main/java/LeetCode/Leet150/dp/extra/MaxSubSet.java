package LeetCode.Leet150.dp.extra;

public class MaxSubSet {

    public int subsetSum(int wt[],int val[],int w,int n ){
        if(n==0 || w==0){
            return 0;
        }
        if(wt[n-1]<w){
            return Math.max(val[n-1]+subsetSum(wt,val,w-wt[n-1],n-1),subsetSum(wt,val,w,n-1));
        }else{
            return subsetSum(wt,val,w,n-1);
        }
    }
}
