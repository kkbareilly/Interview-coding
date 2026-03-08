package BinaryTree;

public class HeighOfTree {
    public static void main(String[] args) {
        System.out.println(height(Node.buildTree()));
    }


    public static  int height(Node node){
        if(node==null)
            return 0;

        return  Math.max(height(node.left),height(node.right))+1;

    }
}
