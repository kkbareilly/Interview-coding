package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int mat[][]={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(getSpiral(mat));
    }
    public  static List<Integer> getSpiral(int mat[][]){
         List<Integer> res=new ArrayList<>();

        if(mat.length==0)
            return res;
        int rowBeg=0;
        int colBeg=0;
        int rowEnd=mat.length-1;
        int colEnd=mat[0].length-1;
        while (rowBeg<=rowEnd&& colBeg<=colEnd){

            for(int i=colBeg;i<=colEnd;i++){
                res.add(mat[rowBeg][i]);
            }
            rowBeg++;
            for(int i=rowBeg;i<=rowEnd;i++){
                res.add(mat[i][colEnd]);
            }
            colEnd--;
            if(rowBeg<=rowEnd){
                for(int i=colEnd;i>=colBeg;i--){
                    res.add(mat[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colBeg<=colEnd){
                for(int i=rowEnd;i>=rowBeg;i--){
                    res.add(mat[i][colBeg]);
                }
            }
            colBeg++;

        }
        return res;
    }
}
