package matrix;

public class NumberOfPathWithKCoin {

    public static void main(String[] args) {
        int k = 12;
        int mat[][] = {{1, 2, 3},
                {4, 6, 5},
                {3, 2, 1}
        };
        System.out.println(solve(mat,2,2, k));
    }
    public static int solve(int mat[][],int m,int n,int k){

        if(m<0 || n<0)
            return 0;
        if(m==0&&n==0 &&(k==mat[m][n]))
            return 1;
       return solve(mat,m,n-1,k-mat[m][n])+solve(mat,m-1,n,k-mat[m][n]);
    }
}
