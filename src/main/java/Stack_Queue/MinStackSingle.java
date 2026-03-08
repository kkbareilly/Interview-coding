package Stack_Queue;

import java.util.Stack;

public class MinStackSingle {

    private Stack<Integer> st1;
  private  int minVal=Integer.MIN_VALUE;
    MinStackSingle(){
        st1=new Stack();

    }
    public void enQueue(int val){
        if(st1.isEmpty()){
            st1.push(val);
        }else
        {
           if(val<st1.peek()) {
               st1.push(2*val-minVal);
               minVal=val;
           }
        }
    }

    public int deQueue(){
      if(st1.empty())
          return -1;
      if(st1.peek()<minVal){
          minVal=2*minVal-(st1.peek());
         return st1.pop();
      }
      return 0;
    }

    public int minDequeue(){
        return minVal;
    }
}
