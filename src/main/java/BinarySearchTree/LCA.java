package BinarySearchTree;

public class LCA {


    public Node lcs(Node node,Node node1,Node node2){
        if(node==null)
            return null;
        if(node1==null || node2==null)
            return node;
        while (node!=null) {
            if (node1.data < node.data && node2.data < node.data)
                node = node.left;
            else if ((node1.data > node.data && node2.data > node.data))
                node = node.right;
            else
                break;
        }
        return node;
    }
}
