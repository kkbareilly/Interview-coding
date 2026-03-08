package BinaryTree;

public class IsMirrorStructure {

    public boolean isSymmetric(Node root) {
        if(root==null)
            return true;
        return isMirror(root,root);
    }

    public boolean isMirror(Node n1,Node n2){
        if(n1==null&&n2==null)
            return true;
        if(n1==null || n2==null)
            return false;
        return n1.data==n2.data&&isMirror(n1.left,n2.right)&&isMirror(n1.right,n2.left);
    }
}
