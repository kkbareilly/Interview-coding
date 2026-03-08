package BinarySearchTree;

public class BSTToSortedDoubleLinkList {

    Node head=null;
    Node prev=null;

    public void convertTODLL(Node root){

        if(root==null)
            return ;
        convertTODLL(root.left);

        if(prev==null){
            head=root;
        }else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        convertTODLL(root.right);
    }
}
