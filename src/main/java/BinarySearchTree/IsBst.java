package BinarySearchTree;

public class IsBst {

    Node prev;

    public boolean isBSt(Node node){

        if(node==null)
            return true;
        if(!isBSt(node.left))
            return false;
        if(prev!=null && node.data<=prev.data)
            return false;
        prev=node;
        return isBSt(node.right);
    }
}
