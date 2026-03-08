package BinaryTree;

public class BinaryTree {

}

class Node{
    int data;
     Node left;
     Node right;

    public Node(int data){
         this.data=data;
         this.left=null;
         this.right=null;
     }
     public static Node createNode(int data){

         return new Node(data);

     }

     public static Node buildTree(){
         Node root=Node.createNode(10);
         root.left=Node.createNode(9);
         root.right=Node.createNode(20);
         root.left.left=Node.createNode(5);
         root.left.right=Node.createNode(8);
         root.right.left=Node.createNode(18);
         root.right.right=Node.createNode(22);
         root.right.right.left=Node.createNode(21);
         return root;
     }
}
     //       10
    //    9          20
  //  5        8 18        22