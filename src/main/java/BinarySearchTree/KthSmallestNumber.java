package BinarySearchTree;


public class  KthSmallestNumber {


    public static int counter=0;

    public static Node kthSmallest(Node node,int k){
        if(node==null)
            return  null;
      Node lest=  kthSmallest(node.left,k);

        if(lest!=null)
            return lest;
        counter++;
        if(counter==k)
            return node;
     return kthSmallest(node.right,k);

    }
}
