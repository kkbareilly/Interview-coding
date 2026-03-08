package matrix;

public class MatrixDiagonals {
    public static void main(String[] args) {

        int mat[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        int i=0;
        int j=0;
        for(int k=0;k<mat[0].length-1;k++){
            i=k;
            j=0;
            while(i>=0){
                System.out.print(mat[i][j]);

                i=i-1;
                j=j+1;
            }
            System.out.println("=======");

        }

        for(int k=1;k<=mat[0].length-1;k++){
            i=(mat.length-1);
            j=k;
            while(j<=mat[0].length-1){
                System.out.print(mat[i][j]);

                i=i-1;
                j=j+1;
            }
            System.out.println("=======");

        }
    }
}
