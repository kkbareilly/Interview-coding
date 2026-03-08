package LeetCode.Leet150.backTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public List<String> generateParenthesis(int n) {

        List<String> output=new ArrayList<>();
       backTrack(output,"",0,0,n);
       return output;
    }


    private void backTrack(List<String>outPut,String currentString,int open,int close,int max){
        if(currentString.length()==max*2){
             outPut.add(currentString);
             return;
        }
        if(open<max)
            backTrack(outPut,currentString+"(",open+1,close,max);
        if(close<open)
            backTrack(outPut,currentString+")",open,close+1,max);
    }

}
