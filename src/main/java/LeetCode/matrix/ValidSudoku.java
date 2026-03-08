package LeetCode.matrix;

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValid(int a[][]){

        HashSet set=new HashSet();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(a[i][j]!='.')
                if(!set.add("Row"+i+a[i][j]) ||!set.add("Col"+j+a[i][j])){
                    return false;
                }
                if(!set.add("Box"+(((i/3)*3)+j/3)+a[i][j]) ){
                    return false;
                }
            }
        }
        return true;
    }
}
