package Stack_Queue;

import java.util.Stack;

public class QueueUsingStack {

    Stack st1=new Stack();
    Stack st2=new Stack();

    public static void main(String[] args) {
        QueueUsingStack qs=new QueueUsingStack();
        qs.enqueue(40);
        qs.enqueue(45);

        qs.enqueue(32);

        qs.enqueue(34);
        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());


    }
private  void enqueue(int data){

    if(st1!=null){
        st1.push(data);
    }


}



public int dequeue(){
      int data=0;
    if(st2.isEmpty()){
        while (!st1.isEmpty()){
            st2.push(st1.pop());
        }
        data=(int)st2.pop();
    }

    if(st1.isEmpty()){
        while (!st2.isEmpty()){
            st1.push(st2.pop());
        }
        data=(int)st1.pop();
    }
    return data;
}

}
