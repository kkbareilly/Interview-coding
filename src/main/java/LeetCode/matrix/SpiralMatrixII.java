package LeetCode.matrix;

public class SpiralMatrixII {



    public int[][] generateMatrix(int n){
        int r1=0;
        int r2=n-1;
        int c1=0;
        int c2=n-1;
        int val=0;
        int mat[][]=new int[n][n];
        while (r1<r2 && c1<c2){
            for(int c=c1;c<c2;c++){
                mat[r1][c]=val++;
            }
            for(int r=r1+1;r<r2;r++){
                mat[r][c2]=val++;
            }
            if(r1<r2&&c1<c2){
                for(int c=c2-1;c>c1;c--){
                    mat[r2][c]=val++;
                }

                for(int r=r2;r>r1;r--){
                    mat[r][c1]=val++;
                }
            }
            r1++;r2--;
            c1++;c2--;
        }
        return mat;
    }
}
