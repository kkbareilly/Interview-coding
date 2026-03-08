package LeetCode.Leet150.binaryTree;

public class SumRootToLeafNumber {
       int total=0;
    public int sumNumbers(Node root) {
        total=0;
        sumRootToLeaf(root,0);
        return total;
    }
    public void sumRootToLeaf(Node root,int sum){
        if(root==null)
            return ;
         sum=sum*10+root.data;
        if(root.left==null && root.right==null){
            total+=sum;
            return;
        }
        sumRootToLeaf(root.left,sum);
        sumRootToLeaf(root.right,sum);
    }


}
