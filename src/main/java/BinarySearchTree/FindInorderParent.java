package BinarySearchTree;

public class FindInorderParent {
    public static void main(String[] args) {
        System.out.println(inorderParent(BST.buildBST(),6).data);
    }
    public static Node inorderParent(Node node,int val){

        if(node==null)
            return null;

        Node parent=null;

        while (node!=null){

            if(val< node.data){
                parent=node;
                node=node.left;
            }else if(val> node.data){
                node=node.right;
            }else
                break;;
        }

       return node!=null?parent:null;
    }
}
