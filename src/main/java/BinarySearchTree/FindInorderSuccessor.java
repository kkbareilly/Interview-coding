package BinarySearchTree;

public class FindInorderSuccessor {
    public static void main(String[] args) {
        System.out.println(inorderSuccessor(BST.buildBST(),3).data);
    }

    public static Node inorderSuccessor(Node node,int val){
        if(node==null)
            return null;

        Node inorderSuccessor=null;
        while (node!=null) {
            if (val < node.data) {
                inorderSuccessor=node;
                node = node.left;
            }else if(val>node.data){
                node=node.right;
            }else{
                if(node.right!=null){
                inorderSuccessor=getSuccessor(node);
                }
                break;
            }
        }
        return node!=null?inorderSuccessor:null;
    }

    private static Node getSuccessor(Node node){
        if(node==null){
            return null;
        }
        Node temp=node.right;

        while (temp.left!=null){
            temp=temp.left;
        }
        return temp;
    }
}
