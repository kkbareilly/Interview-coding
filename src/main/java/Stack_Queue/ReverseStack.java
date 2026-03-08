package Stack_Queue;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(20);
        st.push(40);

        st.push(50);

        st.push(60);
        st.push(500);
        while (!st.isEmpty())
            System.out.println(st.pop());

    }
public void reverseStack(Stack st){

    if(st.isEmpty()) return;
    int temp=(int)st.pop();
    reverseStack(st);
    insetAtBottom(st,temp);

}


    public void insetAtBottom(Stack st, int data){
        if(st.isEmpty()){
        st.push(data);
         return ;
        }
        int temp=(int)st.pop();
        insetAtBottom(st,data);
        st.push(temp);

    }
}
