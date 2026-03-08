package BinarySearchTree;

public class FindParentNode {
    public static void main(String[] args) {
        System.out.println(parentNode(BST.buildBST(),88).data);
    }

    public static Node parentNode(Node node,int val){
        if(node==null)
            return null;

        Node parent=null;
    while(node!=null){
        if(node.data>val){
            parent=node;
            node=node.left;
        }else if(node.data<val){
            parent=node;
            node=node.right;
        }else
            break;
}
   return node!=null?parent:null;
    }
}
