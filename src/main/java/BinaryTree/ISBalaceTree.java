package BinaryTree;

public class ISBalaceTree {


    public int isBalace(Node node){
        if(node==null)
            return 0;
        if(node.left==null && node.right==null)
            return 1;
        int lh=isBalace(node.left);
        int rh=isBalace(node.right);
        if(lh==-1 || rh==-1)
            return -1;
        if(Math.abs((lh-rh))>1)
            return -1;
        return Math.max(lh,rh)+1;
    }
}
