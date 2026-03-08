package LeetCode.Leet150.binaryTree.additional;

import java.util.LinkedList;
import java.util.Queue;

public class PrintElementBetweenLevel {

    public void printBetween(Node node,int min,int max){
        if(node==null)
            return;
        Queue<Node> q=new LinkedList();
        q.add(node);
        int l=0;
        while(true){
            int size=q.size();
            if(size==0 || l>max){
                break;
            }
            while (size>0){
                Node n=q.poll();
                if(l>min &&l<max){
               System.out.println(n.data);
                }
                if(n.left!=null){
                    q.add(n.left);
                }
                if(n.right!=null){
                    q.add(n.right);
                }
                size--;
            }
            l++;
        }
    }
}
