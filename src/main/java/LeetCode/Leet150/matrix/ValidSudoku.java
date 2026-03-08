package LeetCode.Leet150.matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<String>valid=new HashSet<>();
        for(int i=0;i<board[0].length;i++){
            for (int j=0;j<board.length;j++){
                char c=board[i][j];
                if(c!='.'){
                    if(!valid.add(c+" at row"+i) || !valid.add(c+" at col "+j) || !valid.add(c+" at box "+i/3+"-"+j/3)){
                        return false;
                    }

                }
            }
        }
        return true;
    }
}
