package LeetCode.Leet150.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReghtView {
    ArrayList<Integer> result=new ArrayList<>();
    public List<Integer> rightSideView(Node root) {
        rightView(root,0);
        return result;
    }
public void rightView(Node root,int level){
        if(root==null)
            return;
        if(result.size()==level)
            result.add(root.data);
        rightView(root.right,level+1);
        rightView(root.left,level+1);


}




public void rightViewItr(Node root){
        if(root==null)
            return;
    Queue<Node> q=new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()){
        int size=q.size();
        while (size-->0){
              Node node=q.poll();
              if (size==0)
                  result.add(node.data);
            if(node.left!=null)
                q.add(node.left);
            if(node.right!=null)
                q.add(node.right);
        }
    }
}
}
