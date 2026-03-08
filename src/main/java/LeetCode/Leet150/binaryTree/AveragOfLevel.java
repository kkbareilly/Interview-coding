package LeetCode.Leet150.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AveragOfLevel {
    List<Double> result=new ArrayList();
    public List<Double> averageOfLevels(Node root) {
        if(root==null)
            return result;
        Queue<Node> q=new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int count=size;
            int sum=0;
            while(size-->0){
                Node node=q.poll();
                sum+=node.data;
                if(size==0){
                    Double d=Double.valueOf(sum/count);
                      result.add(d);
                }
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }
        return result;
    }
}
