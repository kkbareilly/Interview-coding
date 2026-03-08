package BinarySearchTree;

public class MaxAndMinInBinarySearch {


    public static void main(String[] args) {
        System.out.println(max(BST.buildBST()));

        System.out.println(min(BST.buildBST()));

    }
    public static int max(Node node){
        if(node==null)
            return -1;

        while (node.right!=null){
            node=node.right;
        }

        return node.data;
    }

    public static int min(Node node){
        if(node==null)
            return -1;

        while (node.left!=null){
            node=node.left;
        }

        return node.data;
    }

}
