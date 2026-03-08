package LeetCode.matrix;

public class Searcin2DMatrix {

    public boolean search(int[][]mat,int target){

        int row=mat.length;
        int col=mat[0].length;
        int start=0;
        int end=col-1;

        while (start<row && end>0){

            int result=mat[start][end];
            if(result==target)
                return true;
            else if(result<target)
                start++;
            else
                end--;

        }

       return false;

    }
}
