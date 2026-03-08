package LeetCode.Leet150.stack;

import java.util.Arrays;
import java.util.Stack;

public class SimplifiedPath {
public static void main(String[] args){
    String s="/home/../kk/./p";
    System.out.println(simplifyPath(s));
}
    public static String simplifyPath(String path) {
        if(path==null)
            return "";
        String tockens[]=path.split("/+");
        Stack<String> st=new Stack<>();
        for(String token:tockens){
            if(st.size()>0 &&"..".equals(token)){
                st.pop();
            }else if( !Arrays.asList("",".","..").contains(token)){
                    st.push(token);
                }

        }
        StringBuilder str=new StringBuilder();
        for(String s:st){
             str.append("/").append(s);
        }
       return str.length()==0?"/":str.toString();
    }
}
