package LeetCode.Leet150.binaryTree.additional;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public void levelOrder(Node node){
        if(node ==null)
            return;
        Queue<Node> que=new LinkedList();
        que.add(node);
        que.add(null);
        while (!que.isEmpty()){
            Node n=que.poll();
            if(n==null&que.size()>0){
                que.add(null);
            }else if(que.size()>0){
                System.out.println(node.data);

                if(n.left!=null){
                    que.add(n.left);
                }
                if(n.right!=null){
                    que.add(n.right);
                }
            }
        }
    }
}
