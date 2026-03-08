package LeetCode.Leet150.binaryTree;

public class MaximumPathSum {
    int maxSum=Integer.MIN_VALUE;
    public static void main(String[] args){
        MaximumPathSum m=new MaximumPathSum();
        m.maxSumPath(new Node(1));
      System.out.println(m.maxSum);
    }
    public int maxSumPath(Node root){
        if(root==null)
            return 0;
        int l=Math.max(0,maxSumPath(root.left));
        int r=Math.max(0,maxSumPath(root.right));
        int currSum=root.data+r+l;
        maxSum=Math.max(currSum,maxSum);
        return Math.max(root.data+l,root.data+r);
    }
}
