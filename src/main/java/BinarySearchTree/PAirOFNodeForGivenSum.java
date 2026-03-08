package BinarySearchTree;

import java.util.Set;

public class
PAirOFNodeForGivenSum {


    public static boolean isPairExist(Node node ,Set elements,int sum){

        if(node==null)
            return false;
        if(elements.contains(sum-node.data))
        {
            return true;
        }
        elements.add(node.data);

       return isPairExist(node.left,elements,sum) || isPairExist(node.right,elements,sum);
    }
}
