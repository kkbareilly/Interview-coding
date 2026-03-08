package LeetCode.Leet150.bst;

public class KthMinimumNide {
    int count=0;
    public int kthSmallest(Node root, int k) {


        Node n= kthSmallestNumber(root,k);
        if(n==null)
            return 0;
        else
            return n.data;
    }

    public Node kthSmallestNumber(Node root, int k) {
        if(root==null)
            return null;
        Node node=kthSmallestNumber(root.left,k);
        if(node!=null)
            return node;
        count++;
        if(count==k)
            return root;

        return kthSmallestNumber(root.right,k);
    }
}
