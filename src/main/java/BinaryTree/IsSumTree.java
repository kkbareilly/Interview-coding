package BinaryTree;

public class IsSumTree {


    public boolean isSumTree(Node node){
        if(node==null || isLeaf(node)){
            return true;
        }
        int leftSum=0;
        int rightSum=0;
        if(isLeaf(node.left)&&isLeaf(node.right)){
            if(node.left==null)
                leftSum=0;
           else if(isLeaf(node.left))
                leftSum=node.left.data;
            else
                leftSum=2*node.left.data;

            if(node.right==null)
                rightSum=0;
            else if(isLeaf(node.right))
                rightSum=node.right.data;
            else
                rightSum=2*node.right.data;
            if(node.data==leftSum+rightSum)
                return true;
            else
                return false;
        }
        return false;
    }
    private boolean isLeaf(Node node){
        if(node.left==null && node.right==null){
            return true;
        }else
            return false;
    }
}
