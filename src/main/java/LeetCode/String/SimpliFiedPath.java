package LeetCode.String;

import java.util.*;

public class SimpliFiedPath {

public static void main(String[] args){
    String s="/a/./b/../../c/";
    String p="/home/";
    System.out.println(simplifiedPath(p));
}
    public static String simplifiedPath(String path ){
        Stack<String> st = new Stack<>();
        String data[]=path.split("/+");
        for (String dt:data){
            if(dt.equals("..") && st.size()>0){
                st.pop();
            }else if(!Arrays.asList(" ",".","..").contains(dt) ){
                st.push(dt);
            }
        }
        StringBuilder sb=new StringBuilder();
        Object []ds=st.toArray();
        for (int i=ds.length-1;i>0;i--){
            sb.append("/").append(ds[i]);
        }
        return  sb.length()==0?"/":sb.toString();
    }
    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for(String s: path.split("/")){
            if(s.equals("..") ) stack.poll();
            else if(!s.equals("") && !s.equals(".")) stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        if(stack.size() == 0) return "/";
        while(stack.size() != 0) sb.append("/").append(stack.pollLast());
        return sb.toString();
    }
}
