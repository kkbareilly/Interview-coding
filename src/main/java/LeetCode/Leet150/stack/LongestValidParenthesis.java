package LeetCode.Leet150.stack;

import java.util.Stack;

public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {

        int stack[]=new int[s.length()+1];
        int index=-1;
        int max=0;
        stack[++index]=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack[++index]=i;
            }else{
                --index;
                if(index==-1){
                    stack[++index]=i;
                }else {
                    max=Math.max(max,i-stack[index]);
                }
            }
        }
        return max;
    }


    public int lvp(String s){
        int left=0;
        int right=0;
        int max=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='(')
                left++;
            else
                right++;
            if(left==right)
               max= Math.max(max,left*2);
            else if(right>left){
                left=0;
                right=0;
            }
        }
        left=0;
        right=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='(')
                left++;
            else
                right++;
            if(left==right)
                max= Math.max(max,left*2);
            else if(left>right){
                left=0;
                right=0;
            }
        }
        return  max;
    }
}
