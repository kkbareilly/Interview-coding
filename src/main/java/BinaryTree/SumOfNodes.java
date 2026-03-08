package BinaryTree;

public class SumOfNodes {
    public static void main(String[] args) {

        System.out.println(sumOfNode(Node.buildTree()));

    }

    public static int sumOfNode(Node node){

        if(node==null)
            return 0;
        return node.data+sumOfNode(node.left)+sumOfNode(node.right);
    }
}
