package BinaryTree;

public class NumberOfLeafNode {
    public static void main(String[] args) {
        System.out.println();
    }

    public static int leafNode(Node node){

        if(node==null)
            return 0;
        if(node.left==null && node.right==null)
            return 1;
        return leafNode(node.left)+leafNode(node.right);
    }
}
