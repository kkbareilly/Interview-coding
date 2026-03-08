package Stack_Queue;

import java.util.Stack;

public class SortStackAcending {

    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(20);
        st.push(2);

        st.push(23455);

        st.push(60);
        st.push(500);
        Stack str=Sort(st);
        while (!str.isEmpty())
            System.out.println(str.pop());
    }
    public static Stack Sort(Stack st){
        Stack ptrst=new Stack();
        while (!st.isEmpty()){
            int data=(int)st.pop();
            while (!ptrst.isEmpty() && (int)ptrst.peek()>data){
                st.push(ptrst.pop());
            }
            ptrst.push(data);
        }
        return ptrst;
    }
}
