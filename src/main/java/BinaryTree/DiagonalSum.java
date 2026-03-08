package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalSum {





    public void diagonalSUm(Node node){

        if(node==null)
            return;
        Queue<Node> queue=new LinkedList();
        queue.add(node);

        while (true){
            int size= queue.size();
            if(size==0)
                break;
            int s=0;

            while (size>0){
                Node temp= queue.remove();
                while (temp!=null){
                    s=s+temp.data;
                    if(temp.left!=null){
                        queue.add(temp.left);
                    }

                    temp=temp.right;
                }
                size--;
            }
            System.out.println(s);
        }
    }

}
