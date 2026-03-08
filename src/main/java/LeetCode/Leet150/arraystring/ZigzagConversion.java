package LeetCode.Leet150.arraystring;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ZigzagConversion {

    public String convert(String s,int rows){
        String res[]=new String[rows];
        int i=0;
        while (i<s.length()){
            for(int j=0;j<rows &i>0;j++){
                res[j]+=s.charAt(i++);
            }
            for(int p=rows-2;p>0;p--){
                res[p]+=s.charAt(i++);

            }
        }
        return Arrays.stream(res).collect(Collectors.joining());
    }
}
