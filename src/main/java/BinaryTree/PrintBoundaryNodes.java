package BinaryTree;

public class PrintBoundaryNodes {


    //print root
    //print left
    //print leaves
    //print right
    public static void main(String[] args) {
        Node root=Node.buildTree();
        System.out.println(root.data);
        printLeft(root.left);
        printLeaves(root.left);

        printLeaves(root.right);
        printRight(root.right);
    }

    private static void printLeft(Node node){

        if(node==null)
            return;
     if(node.left!=null){
         System.out.println(node.data);
         printLeft(node.left);
     } else  if(node.right!=null)   {
         System.out.println(node.data);
         printLeft(node.right);
     }
    }

    private static void printLeaves(Node node){
        if(node==null)
            return;

        printLeaves(node.left);

        if(node.left==null && node.right==null)
            System.out.println(node.data);
        printLeaves(node.right);
    }

    private static void  printRight(Node node){
        if(node==null)
            return;
        if(node.right!=null) {
            printRight(node.right);
            System.out.println(node.data);
        }else if( node.left!=null){
            printRight(node.left);
            System.out.println(node.data);

        }
    }
}
