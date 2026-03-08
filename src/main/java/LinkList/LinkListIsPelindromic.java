package LinkList;

import java.util.Stack;

public class LinkListIsPelindromic {


    public static boolean palindrom(Node node){
        if(node==null)
            return true;
        Stack<Node> st=new Stack<>();

        Node fast=node;
                Node slow=node;
        st.push(slow);
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            st.push(slow);
        }
        if(fast.next==null)
            st.pop();
        Node secondHalf=slow.next;
        while (secondHalf!=null){
            if(st.pop().data!=secondHalf.data)
                return false;
            secondHalf=secondHalf.next;
        }
        return true;
    }
}
