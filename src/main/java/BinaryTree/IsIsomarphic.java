package BinaryTree;

public class IsIsomarphic {

    public boolean isIsomarphic(Node node1,Node node2){
        if(node1==null && node2==null)
            return true;
        if(node1==null || node2==null)
            return false;
        if(node1.data!=node2.data)
            return false;
        return (isIsomarphic(node1.left,node2.left) &&isIsomarphic(node1.right,node2.right))||(isIsomarphic(node1.right,node2.left) &&isIsomarphic(node1.left,node2.right));
    }
}
