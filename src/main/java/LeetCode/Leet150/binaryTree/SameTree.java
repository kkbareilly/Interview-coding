package LeetCode.Leet150.binaryTree;

public class SameTree {


        public boolean isSameTree(Node p, Node q) {
            if(p==null && q==null)
                return true;
            if(p==null || q==null)
                return false;
            return p.data==q.data && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }


}
