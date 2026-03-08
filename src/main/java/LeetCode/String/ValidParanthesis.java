package LeetCode.String;

import java.util.Stack;

public class ValidParanthesis {



    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                if(c==']' && stack.peek()!='[') return false;
                if(c==')' && stack.peek()!='(') return false;
                if(c=='}' && stack.peek()!='{') return false;

                // all good then
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
