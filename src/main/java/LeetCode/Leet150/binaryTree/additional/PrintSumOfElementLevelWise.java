package LeetCode.Leet150.binaryTree.additional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintSumOfElementLevelWise {

    public void printLevelWise(Node node){
        if(node==null)
            return;
        Queue<Node> q=new LinkedList();
        List<Integer> result=new ArrayList<>();
        q.add(node);
        q.add(null);
        int sum=0;
        while (!q.isEmpty()){
            Node n=q.poll();
            if(n==null&&q.size()>0){
               q.add(null);
               result.add(sum);
               sum=0;
            }else if(q.size()>0){
                sum+=node.data;
            }
        }

    }
}
