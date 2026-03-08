package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintTreeInReverseOrder {

    public static void main(String[] args) {
       // reverse(Node.buildTree());
        iterativeReverse(Node.buildTree());
    }

    public static void reverse(Node node){

        if(node==null)
            return;

        int height=HeighOfTree.height(node);
        for(int i=height;i>0;i--){
            PrintNodeAtGivenLevel.PrintNode(node,i);
            System.out.println("   "
            );
        }
    }

    public static void iterativeReverse(Node node){

        if(node==null)
            return;
        Queue<Node>q=new LinkedList<Node>();
        Stack<Node> st=new Stack<Node>();
        q.add(node);

        while (!q.isEmpty()){
            Node n=q.poll();
            st.add(n);
                    if(n.left!=null){
                        q.add(n.left);
                    }
            if(n.right!=null){
                q.add(n.right);
            }
        }
        while (!st.isEmpty()){
            System.out.println(st.pop().data);
        }

    }
}
