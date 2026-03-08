package LeetCode.Leet150.binaryTree;



public class NumberOfNodesInCompleteBinaryTree {

    public int countNodes(Node root) {
        if(root==null)
            return 0;
        int leftLength=leftDepth(root);
        int rightLength=rightDepth(root);
        if(leftLength==rightLength)
            return (int)Math.pow(2,leftLength)-1;
        else
         return    1+countNodes(root.left)+countNodes(root.right);

    }

    private int leftDepth(Node node){
        int length=0;
        while (node!=null){
            node=node.left;
            length++;
        }
        return length;
    }

    private int rightDepth(Node node){
        int length=0;
        while (node!=null){
            node=node.right;
            length++;
        }
        return length;
    }
}

class Node{
    Node left;
    Node right;
    Node next;
    int data;
    Node(int data){
        this.left=null;
        this.right=null;
        this.data=data;
        this.next=null;
    }
}
