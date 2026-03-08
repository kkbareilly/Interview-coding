package LeetCode.Leet150.binaryTree.additional;

public class PrintReverseOrderTraversal {

    public void reverseTraversal(Node node){
        int height=height(node);
        for(int i=height-1;i>0;i--){
            levelOrder(node,i);
        }
    }


    public int height(Node node){
        if(node==null)
            return 0;
        return Math.max(height(node.left),height(node.right))+1;

    }

    public void levelOrder(Node node, int level){
        if(node==null)
            return;;
            if(level==1){
                System.out.println(node.data);
            }
            levelOrder(node.left,level-1);
            levelOrder(node.right,level-1);
    }
}
