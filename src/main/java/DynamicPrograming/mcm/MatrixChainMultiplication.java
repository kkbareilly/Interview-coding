package DynamicPrograming.mcm;

public class MatrixChainMultiplication {



    public static int solve(int a[],int i,int j){

        if(i>=j)
            return 0;

        int min=Integer.MAX_VALUE;
        for(int k=i;k<j-1;k++){

            int temp=solve(a,i,k)+solve(a,k+1,j)+(a[i-1]*a[k]*a[j]);

            if(temp<min){
                min=temp;
            }
        }
        return min;
    }
}
