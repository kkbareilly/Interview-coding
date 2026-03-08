package LeetCode.Leet150.binaryTree;

public class SumPath {

    public boolean hasPathSum(Node root, int targetSum) {
      return sumPath(root,0,targetSum);
    }

    public boolean sumPath(Node root,int sum,int target) {
        if(root==null)
            return false;
        sum+=root.data;
        if(root.left==null && root.right==null)
            if(sum==target)
                return true;
        return sumPath(root.left,sum,target) || sumPath(root.right,sum,target);

    }
}
