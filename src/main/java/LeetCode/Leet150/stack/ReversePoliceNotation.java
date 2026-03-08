package LeetCode.Leet150.stack;

import java.util.Stack;

public class ReversePoliceNotation {
public static void main(String[] args){
    String [] tockens=new String[] {"4","13","5","/","+"};
    System.out.println(evalRPN(tockens));
    ;
}
    public  static int evalRPN(String[] tokens) {
        Stack<Integer>st=new Stack<>();
        String operator="+-*/";
        for(String s:tokens){
            if(operator.indexOf(s)!=-1){
                int res=0;
                int d1=st.pop();
                int d2=st.pop();
                if(s.equals("+")){
                    res=d1+d2;
                }else if(s.equals("-")){
                    res=d2-d1;
                }else if(s.equals("*")){
                    res=d1*d2;
                }else if(s.equals("/") && d1!=0){
                    res= d2/d1;

                }

                st.push(res);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}
