package Stack_Queue;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> st1;
    private  Stack<Integer> st2;
    MinStack(){
        st1=new Stack();
        st2=new Stack();
    }
    public void enQueue(int val){
        st1.push(val);
        if(st2.isEmpty()){
            st2.push(val);
        }else
        {
           if(val<st2.peek()) {
               st2.push(val);
           }
        }
    }

    public int deQueue(){
       int val= st1.pop();
        if(val==st2.peek())
            st2.pop();

        return val;
    }

    public int minDequeue(){
        if(st2.empty())
            return -1;
        return st2.pop();
    }
}
