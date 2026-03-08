package DynamicPrograming.bounded;

public class SubSetSumRecursive {


    public boolean subSet(int a[],int sum,int n){
        if(a==null || n==0 || sum==0)
            return false;
        if(a[n-1]<sum){
            return subSet(a,sum-a[n-1],n-1)||subSet(a,sum,n-1);
        }else
            return subSet(a,sum,n-1);
    }
}
