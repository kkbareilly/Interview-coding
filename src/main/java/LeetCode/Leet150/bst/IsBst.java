package LeetCode.Leet150.bst;

public class IsBst {
    Node prev=null;
    public boolean isBst(Node root){
        if(root==null)
            return true;
        if(!isBst(root.left))
             return false;
        if(prev!=null && root.data<prev.data)
             return false;
        prev=root;
        return isBst(root.right);
    }
}
