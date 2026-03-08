package LeetCode.Leet150.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator {

    List<Integer> list=new ArrayList<>();
    int i=-1;
    public void inOrder(Node root){
        if(root==null)return;
        inOrder(root.left);
        list.add(root.data);
        inOrder(root.right);

    }
    public BSTIterator(Node root) {
        inOrder(root);
    }

    public int next() {
        i++;
        return list.get(i);
    }

    public boolean hasNext() {
        return i+1<list.size()?true:false;
    }
}
