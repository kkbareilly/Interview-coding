package LeetCode.Leet150.binaryTree.additional;

public class HeightOftree {


    public int height(Node node){
        if(node==null)
            return 0;
        return Math.max(height(node.left),height(node.right))+1;
    }
}
