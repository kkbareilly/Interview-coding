package BinaryTree;

import java.util.Stack;

public class PrintInSpiralOrder {

    public static void main(String[] args) {
        spiral(Node.buildTree());
    }

    public static void spiral(Node node){

        Stack<Node> st1=new Stack();
        Stack<Node> st2=new Stack();
        st1.add(node);

                while(!st1.isEmpty() || !st2.isEmpty()){

                    while(!st1.isEmpty()){
                        Node n=st1.pop();
                        if(n!=null) {
                        System.out.print(n.data+" ");
                        if(n.left!=null){
                            st2.add(n.left);
                        }
                        if(n.right!=null) {
                            st2.add(n.right);
                        }
                        }
                    }
                    System.out.println();

                    while(!st2.isEmpty()){
                        Node n=st2.pop();
                         if(n!=null) {
                             System.out.print(n.data+" ");
                             if (n.right != null) {
                                 st1.add(n.right);
                             }
                             if (n.left != null) {
                                 st1.add(n.left);
                             }
                         }
                         }
                    System.out.println();

                }
    }
}
