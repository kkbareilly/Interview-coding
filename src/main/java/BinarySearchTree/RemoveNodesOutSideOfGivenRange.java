package BinarySearchTree;

public class RemoveNodesOutSideOfGivenRange {



    public Node remove(Node node,int min,int max){
        if(node==null)
            return null;
        node.left=remove(node.left,min,max);
        node.right=remove(node.right,min,max);
        if(node.data<min)
            return node.right;
        else if(node.data>max)
            return node.left;
        else
            return node;
    }
}
