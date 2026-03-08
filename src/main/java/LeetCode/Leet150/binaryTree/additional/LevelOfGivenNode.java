package LeetCode.Leet150.binaryTree.additional;

public class LevelOfGivenNode {

    public int getLevel(Node node,int val,int level){
        if(node==null)
            return 0;
        if(node.data==val){
            return level;
        }
        int l=getLevel(node.left,val,level+1);
        if(l!=0)
            return l;
      l=   getLevel(node.right,val,level+1);
      return l;
    }
}
