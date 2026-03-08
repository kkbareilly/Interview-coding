package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue q1=new LinkedList();
    Queue q2=new LinkedList();

    public static void main(String[] args) {
        StackUsingQueue st=new StackUsingQueue();
        st.push(20);
        st.push(40);
        st.push(30);
        st.push(56);
        st.push(70);
        System.out.println(st.pop());
        System.out.println(st.pop());

        System.out.println(st.pop());



    }

    public void push(int data){

        if(q1.isEmpty())
            q2.offer(data);
        else
            q1.offer(data);
    }

    public int pop(){
        if(q1.isEmpty()){
            while (!q2.isEmpty()){
                q1.offer(q2.poll());
            }
            return (int)q1.poll();
        }else {
            while (!q1.isEmpty()){
                q2.offer(q1.poll());
            }
            return (int)q2.poll();
        }

    }

}
