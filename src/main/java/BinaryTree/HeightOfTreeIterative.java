package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTreeIterative {


    public int height(Node node){
        if(node==null)
            return 0;
        Queue<Node> queue=new LinkedList<Node>();
        int height=0;
        queue.offer(node);
        while (!queue.isEmpty()){
            int size= queue.size();
            if(size<=0)
                break;
            while (size>0){
               Node dat= queue.remove();
               if(node.left!=null){
                   queue.add(node.left);
               }
                if(node.right!=null){
                    queue.add(node.right);
                }
                size--;
            }
            height=height+1;
        }
        return height;
    }
}
