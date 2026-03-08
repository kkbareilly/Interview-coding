package LeetCode.Leet150.bst;

public class AbsoluteMinDiff {
       int mindiff=Integer.MAX_VALUE;
       Node prev=null;
    public int getMinimumDifference(Node root) {
        if(root==null)
            return 0;
        getMinimumDifference(root.left);
        if(prev!=null){
            mindiff=Math.min(mindiff,root.data-prev.data);
        }
        if(root!=null){
            prev=root;
        }
        getMinimumDifference(root.right);
        return mindiff;
    }
}
