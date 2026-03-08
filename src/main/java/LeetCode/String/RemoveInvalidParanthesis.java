package LeetCode.String;

import java.util.*;

public class RemoveInvalidParanthesis {
  public static void main(String[] args) {
    //
    String s ="()())()";
      solution(s,minRemove(s),new HashSet<>());
  }

    public  static int minRemove(String s){
         Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                st.push(s.charAt(i));
            else if(s.charAt(i)==')'){
                if(st.size()==0)
                    st.push(s.charAt(i));
                else if(st.peek()==')')
                    st.push(s.charAt(i));
                else if(st.peek()=='(')
                    st.pop();
            }
        }
        return st.size();
    }

    public static void solution(String str,int mra,HashSet<String> ans){
        if(mra==0){
            int remove=minRemove(str);
      if (remove == 0) {
        if (!ans.contains(str)) {
          System.out.println(str);
          ans.add(str);
        }
            }
            return;
        }

        for(int i=0;i<str.length();i++){
            String left=str.substring(0,i);
            String right=str.substring(i+1);
            solution(left+right,mra-1,ans);
        }
    }
}
