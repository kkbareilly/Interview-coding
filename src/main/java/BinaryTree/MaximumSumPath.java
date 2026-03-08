package BinaryTree;

public class MaximumSumPath {

    int sum=Integer.MAX_VALUE;
    public int maxSum(Node root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return root.data;
        int l=maxSum(root.left);
        int r=maxSum(root.right);
        int one=Math.max(root.data,root.data+Math.max(l,r));
        int max_two=Math.max(one,l+r+root.data);
         sum=Math.max(sum,max_two);
         return one;
    }

    private int maxSumCal(Node root){
        if(root==null)
            return 0;

        int l=Math.max(0,maxSum(root.left));
        int r=Math.max(0,maxSum(root.right));
        int currentSum=root.data+l+r;
          sum =Math.max(sum,currentSum);
          return Math.max(root.data+l,root.data+r);
    }
}

//    7
// -1    3

//    7
// 1    -3

//    7
// -1    -3

//    7
// 1    3