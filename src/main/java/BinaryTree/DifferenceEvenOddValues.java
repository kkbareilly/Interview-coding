package BinaryTree;

public class DifferenceEvenOddValues {

    public static void main(String[] args) {
        System.out.println(diffEvenOdd(Node.buildTree()));
    }

    public static int diffEvenOdd(Node node){
        if(node==null)
            return 0;

        return node.data-diffEvenOdd(node.left)-diffEvenOdd(node.right);
    }
}
