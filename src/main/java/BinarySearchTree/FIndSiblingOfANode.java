package BinarySearchTree;

public class FIndSiblingOfANode {

    public static void main(String[] args) {
        Node n=BST.buildBST();
        System.out.println(getSibling(n,10).data);
        System.out.println("--------");
        BST.print(n);

    }
    public static Node getSibling(Node node,int val){

        if(node==null || node.data==val)
            return node;

        Node parent=null;
        Node sibLing=null;
        while(node!=null){

            if(node.left!=null){
                parent=node;
               // sibLing=parent.right;
                node=node.left;
            } else if(node.right!=null){
                parent=node;
              //  sibLing=parent.left;
                node=node.right;
            }
            else{
               break;
            }
        }
        if(parent!=null && parent.left!=null && val==parent.left.data){
            return parent.right;
        }
        if(parent!=null && parent.right!=null && val==parent.right.data){
            return parent.left;
        }
        return parent;
    }
}
