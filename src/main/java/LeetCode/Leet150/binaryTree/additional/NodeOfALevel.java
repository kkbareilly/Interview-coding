package LeetCode.Leet150.binaryTree.additional;

public class NodeOfALevel {

    public void nodeAtLevel(Node node,int level){
        if(node==null)
            return;;

            if(level==1){
                System.out.println(node.data);
            }

            nodeAtLevel(node.left,level-1);
            nodeAtLevel(node.right,level-1);
    }
}
