package LeetCode.Leet150.binaryTree.additional;

public class TwoTreeIsIdentical {

    public boolean isIdentical(Node n1,Node n2){
        if(n1==null&n2==null)
            return true;
        if(n1==null || n2==null)
            return false;
       return n1.data==n2.data&isIdentical(n1.left,n2.left)&&isIdentical(n1.right,n2.right);
    }
}
