package LeetCode.Leet150.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBST {
    public Node invertTree(Node root) {

        if(root==null)
            return root;
    Queue<Node> que = new LinkedList<>();
    que.add(root);
    while (!que.isEmpty()){
        Node node=que.poll();
        Node temp=node.left;
        node.left=node.right;
        node.right=temp;
        if(node.left!=null)
            que.add(node.left);
        if(node.right!=null)
            que.add(node.right);
    }
    return root;
    }
}
