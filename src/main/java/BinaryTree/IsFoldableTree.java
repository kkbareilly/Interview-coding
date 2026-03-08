package BinaryTree;

public class IsFoldableTree {

    public boolean isFoldable(Node node){
        if(node==null)
            return true;
        return isMirrorStructure(node.left,node.right);
    }

    public boolean isMirrorStructure(Node n1,Node n2){
        if(n1==null && n2==null)
            return true;
        if(n1==null || n2==null)
            return false;
        return isMirrorStructure(n1.left,n2.right) && isMirrorStructure(n1.right,n2.left);

    }
}
