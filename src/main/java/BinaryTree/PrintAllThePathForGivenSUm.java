package BinaryTree;

import java.util.List;

public class PrintAllThePathForGivenSUm {

    public static  void pathSum(Node root, List single,List<List> doublePath,int sum){

        if(root==null)
            return;
        single.add(root.data);
        if(root.left==null && root.right==null && sum==0)
        {
            doublePath.add(single);
        }else {
            pathSum(root.left, single, doublePath, sum - root.data);
            pathSum(root.right, single, doublePath, sum - root.data);
        }
        single.remove(single.size()-1);
    }
}
