package BinaryTree;

import java.util.function.Predicate;

public class PrintNodeAtGivenLevel {

    public static void main(String[] args) {
      //  PrintNode(Node.buildTree(),2);
        levelOrderTraversalUsingRecursion(Node.buildTree());
    }
    public static void PrintNode(Node node,int level){

        if(node==null)
            return;
        if(level==1) {
            System.out.print(node.data+"  ");
            return;
        }
        PrintNode(node.left,level-1);
        PrintNode(node.right,level-1);

    }

    //recursive

    private static void levelOrderTraversalUsingRecursion(Node node){

        if(node==null)
            return;
        int height=HeighOfTree.height(node);
        for (int i=0;i<height;i++){
            PrintNode(node,i+1);
            System.out.println("  ");
        }
    }
}
