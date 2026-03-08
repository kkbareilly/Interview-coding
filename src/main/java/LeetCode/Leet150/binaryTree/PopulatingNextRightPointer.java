package LeetCode.Leet150.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointer {


    public Node nextRight(Node root){

        if(root==null)
            return root;
        Queue<Node> que=new LinkedList<>();
           que.add(root);
        while (!que.isEmpty()){
            int size=que.size();
            Node dumy=new Node(0);
            while (size-->0){
                Node node=que.poll();
                dumy.left=node;
                dumy=dumy.right;
                if(node.left!=null){
                    que.add(node.left);

                }
                if(node.right!=null){
                    que.add(node.right);

                }
            }
        }
        return root;
    }
}
