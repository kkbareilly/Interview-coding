package LeetCode.Leet150.stack;

import java.util.Stack;

public class RemoveConsecutiveCharactor {

    public static void main(String[] args){
        String arr[]={"B","R","G","G","G","B","B","R","G"};
         Stack<String> st=new Stack<>();
        for(String s:arr){
           if(st.isEmpty()){
               st.push(s);
           }else{
               if(st.peek().equalsIgnoreCase(s)){
                   st.pop();
               }else{
                   st.push(s);
               }
           }
        }
        for (String s :st){
        System.out.println(s);
        }

        System.out.println(remove("BRGGGBBRG"));
    }


    public  static String remove(String s){
        char[] stack=s.toCharArray();
        int i=0;
        for(int j=0;j<s.length();j++){
            char current=s.charAt(j);
            if(i>0&& stack[i-1]==current){
                i--;
            }else{
                stack[i]=current;
                i++;
            }
        }
        return new String(stack,0,i);
    }
}
