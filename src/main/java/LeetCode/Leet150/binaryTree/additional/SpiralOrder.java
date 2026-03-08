package LeetCode.Leet150.binaryTree.additional;

import java.util.Stack;

public class SpiralOrder {

    public void spiral(Node node){
        if(node==null)
            return;
        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();
        st1.push(node);
        while (!st1.isEmpty() || !st2.isEmpty()){
            while (!st1.isEmpty()){
                Node n=st1.pop();
                System.out.print(n.data);

                if(n.left!=null){
                    st2.push(node.left);
                }
                if(n.right!=null){
                    st2.push(node.right);
                }
            }
      System.out.println();
            while (!st2.isEmpty()){
                Node n=st2.pop();
                System.out.print(n.data);

                if(n.left!=null){
                    st1.push(node.right);
                }
                if(n.right!=null){
                    st1.push(node.left);
                }
            }
            System.out.println();
        }


    }
}
