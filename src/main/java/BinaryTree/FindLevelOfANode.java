package BinaryTree;

public class FindLevelOfANode {
    public static void main(String[] args) {
        System.out.println(findLevel(Node.buildTree(),8,1));
    }

    public  static int  findLevel(Node node,int data,int level){

        if(node==null)
            return 0;
        int l=0;
        if(node.data==data)
            return level;
        l=findLevel(node.left,data,level+1);
        if(l!=0)
            return l;
        l=findLevel(node.right,data,level+1);
        return l;
    }
}
