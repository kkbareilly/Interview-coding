package BinarySearchTree;

public class ClosestNodeForGivenValue {


    public Node closestNode(Node node,int val){
        if(node==null)
            return null;
        int min=Integer.MAX_VALUE;
        int diff;
        Node diffNode=null;

        while (node!=null){
            diff=Math.abs(node.data-val);
             if(min>diff) {
                 min = diff;
                 diffNode=node;
             }

             if(val>node.data)
                 node=node.right;
             else if(val<node.data)
                 node=node.left;
             else
                 break;;
        }
        return diffNode;

    }
}
