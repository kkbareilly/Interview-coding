package LeetCode.Leet150.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        traverse(new Node(2));
    }
    public static void traverse(Node node){

        if(node==null)
            return;

        Queue<Node> q=new LinkedList<Node>();
        q.add(node);
        q.add(null);

        while (!q.isEmpty()){
            Node n=q.poll();
            if(n==null && q.size()>0){
                q.add(null);
                System.out.println("   ");
            }else if(q.size()>0) {
                System.out.print(n.data+" ");
                if(n.left!=null){
                    q.add(n.left);
                }
                if(n.right!=null)
                    q.add(n.right);
            }
        }
    }
}
