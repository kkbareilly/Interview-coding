package BinaryTree;

public class MaxSumBetweenTwoLeafNode {

    static int Max_Sum=0;
    public static int maxSumPath(Node root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null){
            return root.data;
        }
        int l=maxSumPath(root.left);
        int r=maxSumPath(root.right);
        if(root.left!=null && root.right!=null) {
            Max_Sum=Math.max(l+r+root.data,Max_Sum);

            return Math.max(l, r) + root.data;
        }

        return root.left!=null? l+root.data:r+root.data;

    }
}
