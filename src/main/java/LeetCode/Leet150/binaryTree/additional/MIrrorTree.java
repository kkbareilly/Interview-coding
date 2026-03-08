package LeetCode.Leet150.binaryTree.additional;

public class MIrrorTree {

    public void convertMirror(Node node){
        if(node ==null)
            return ;
        Node t=node.left;
        node.left=node.right;
        node.right=t;
        convertMirror(node.left);
        convertMirror(node.right);
    }
}
