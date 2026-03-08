package DynamicPrograming.bounded;

public class SubSetSumMemorization {
    int sum=10;
    int a[]={};
    int n=a.length;
    boolean mat[][]=new boolean[sum][n];
    public boolean memo(int a[],int sum,int n){
        if(sum==0||n==0)
            return true;
        if(mat[sum][n])
            return mat[sum][n];
        if(a[n-1]<sum)
           return mat[sum][n]=memo(a,sum-a[n-1],n-1)||memo(a,sum,n-1);
        else
           return mat[sum][n]=memo(a,sum,n-1);

    }
}
