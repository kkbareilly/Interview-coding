package LeetCode.Leet150.binaryTree;

public class FlattenTreeTOLinkedList {




    public void flattentoList(Node node){
        if(node==null)
            return;
        Node tempLeft=node.left;
        Node tempRight=node.right;
        node.left=null;
        flattentoList(tempLeft);
        flattentoList(tempRight);
        node.right=tempLeft;
        Node curr=node;
        while (curr.right!=null){
            curr=curr.right;
        }
        curr.right=tempRight;
    }
    //Morris travesal
    /*
    * 1- check left
    * 2- if not null go its right most child
    * 3-connect it to root->right
    * 4-connect whole left to root->right
    * 5-make root->left=null
    * upgrade root to root->right
    * */
    public void flatten(Node node) {
        if(node==null) return;

        while (node!=null){
            if(node.left!=null){
                Node left=node.left;
                Node curr=left;
                while (curr.right!=null)
                    curr=curr.right;
                curr.right=node.right;
                node.left=null;
                node.right=left;
            }
            node=node.right;
        }
    }

}
