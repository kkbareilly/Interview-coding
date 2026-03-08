package LeetCode.Leet150.stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer>st=null;
    Stack<Integer>minStack=null;
    public MinStack() {
        st=new Stack<>();
        minStack=new Stack<>();

    }

    public void push(int val) {
     if(minStack.isEmpty() || val<=minStack.peek()){
         minStack.push(val);

         }
         st.push(val);
    }

    public void pop() {
      if( !minStack.isEmpty()&&!st.isEmpty()&&st.peek().equals(minStack.peek())){
         minStack.pop();
      }
      st.pop();

    }

    public int top() {
         return st.isEmpty()?0:st.peek();
    }

    public int getMin() {
       return minStack.isEmpty()?0:minStack.peek();
    }
}
