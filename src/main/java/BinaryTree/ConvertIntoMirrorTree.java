package BinaryTree;

public class ConvertIntoMirrorTree {
    public static void main(String[] args) {
        ConvertIntoMirrorTree cmt=new ConvertIntoMirrorTree();
       Node node= cmt.mirror(Node.buildTree());
       BinaryTreeIterativeTravesal.inOrder(node);
       System.out.println("--------------------");
        BinaryTreeIterativeTravesal.inOrder(Node.buildTree());


    }

    public Node  mirror(Node node){
        if(node==null)
            return null;
        Node temp=node.left;
        node.left=node.right;
        node.right=temp;
        mirror(node.left);
        mirror(node.right);
        return node;
    }
}
