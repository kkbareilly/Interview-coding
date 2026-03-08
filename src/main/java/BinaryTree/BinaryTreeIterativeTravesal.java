package BinaryTree;

import java.util.Stack;

public class BinaryTreeIterativeTravesal {

    public static void main(String[] args) {
        BinaryTreeIterativeTravesal btt=new BinaryTreeIterativeTravesal();
       // btt.inOrder(Node.buildTree());
        btt.postOrder(Node.buildTree());
    }

    public static void preOrder(Node node){

        if(node==null)
            return;

        Stack st=new Stack();
         st.add(node);

        while (!st.isEmpty()){
           System.out.println(node.data);
           if(node.left!=null)
               st.add(node.left);
           if(node.right!=null)
               st.add(node.right);
        }

    }

    public static void inOrder(Node node){
        if(node==null)
            return;
        Stack<Node> st=new Stack();

        while (node!=null){
            st.add(node);
            node=node.left;
        }

        while (!st.isEmpty()){

             Node n=st.pop();
             System.out.println(n.data);
             if(n!=null && n.right!=null){
                 Node temp=n.right;
                 while (temp!=null){
                     st.add(temp);
                     temp=temp.left;
                 }
             }

        }
    }


    public void postOrder(Node node){

        if(node==null)
            return;

        Stack<Node> st1=new Stack<Node>();
        Stack<Node> st2=new Stack<Node>();

        st1.add(node);

        while (!st1.isEmpty()){
            Node n=st1.pop();
            st2.add(n);
            if(n.left!=null){
                st1.add(n.left);
            }

            if(n.right!=null){
                st1.add(n.right);
            }
        }

        while (!st2.isEmpty()){
            System.out.println(st2.pop().data);
        }
    }
}
