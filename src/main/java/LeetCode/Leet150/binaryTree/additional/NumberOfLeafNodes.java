package LeetCode.Leet150.binaryTree.additional;

public class NumberOfLeafNodes {
    int numberOfNodes;
    public int leafNodes(Node node){
        if(node==null)
            return 0;
        if(node.left==null&node.right==null){
           return 1;
        }
       return 1+leafNodes(node.left)+leafNodes(node.right);
    }
}
