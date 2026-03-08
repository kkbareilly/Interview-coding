package BinaryTree;

 public class DiameterOfTree {
    int diameter=0;
    public int diameter(Node node){
        if(node==null)
            return 0;
        if(node.left==null&&node.right==null)
            return 1;
        int lh=diameter(node.left);
        int rh=diameter(node.right);
        diameter=Math.max(lh+rh+1,diameter);
        return Math.max(lh,rh)+1;
    }
}
