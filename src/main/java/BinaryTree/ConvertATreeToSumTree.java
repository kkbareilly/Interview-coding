package BinaryTree;

public class ConvertATreeToSumTree {

    public int sumTree(Node root){

        if(root==null)
            return 0;
        int old_val=root.data;
        root.data=sumTree(root.left)+sumTree(root.right);
        return root.data+old_val;
    }
}
