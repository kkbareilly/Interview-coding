package LeetCode.String;

import java.util.Stack;

public class LongestValidParentheses {

/*
    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
*/

    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();

        //We push -1 so that if the whole str is ans then we will get ans by 'i - st.peek()' e.g: '(())' = 3 - (-1) = 3 + 1 = 4
        st.push(-1);
        int result = 0;
        for(int i = 0; i < s.length(); i++) {

            //If it's an opening bracket then push in the stack
            if(s.charAt(i) == '(') {
                st.push(i);
            } else {

                st.pop();
                if(st.isEmpty()) {
                    //If the stack is empty, push the current index as a base for the next valid substring.
                    st.push(i);
                } else {
                    //If the stack is not empty, then find the len
                    // gth of current valid substring by taking the difference between the current index and top of the stack.
                    result = Math.max(result, i - st.peek());
                }
            }
        }
        return result;
    }
}
