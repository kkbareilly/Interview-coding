package LeetCode.Leet150.matrix;

public class MatrixZero {

    public int[][] fillZero(int[][]a){
        int r[]=new int[a.length];
        int c[]=new int[a[0].length];
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                if(a[i][j]==0){
                    r[i]=1;
                    c[j]=1;
                }
            }
        }
        for (int i=0;i<r.length;i++){
            for (int j=0;j<c.length;j++){
                if(r[i]==1 || c[j]==1){
                   a[i][j]=0;
                }
            }
        }
        return a;
    }
}
