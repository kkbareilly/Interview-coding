package LeetCode.Leet150.stack;

import java.util.Stack;

public class ValidParentheses {
public static void main(String[] args){
    String s = "([}}])";
    System.out.println(isValid(s));
}
    public static  boolean isValid(String s) {
 if(s.length()%2!=0)
     return false;
        Stack<Character> st=new Stack<>();
        String check="";
 for(char ch:s.toCharArray()){
    if(ch=='('||ch=='[' ||ch=='{'){
        st.push(ch);
    }else if(ch==')' && !st.empty() &&st.peek()=='('){
        st.pop();
    }else if(ch=='}' && !st.empty()&&st.peek()=='{'){
        st.pop();
    }else if(ch==']' &&!st.empty() && st.peek()=='['){
        st.pop();
    }else{
        check=check+ch;
    }
 }
 return st.isEmpty() &&check.length()==0;
    }
}
