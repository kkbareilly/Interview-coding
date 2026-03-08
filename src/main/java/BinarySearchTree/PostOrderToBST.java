package BinarySearchTree;

public class PostOrderToBST {




    public Node createTree(int [] a,int start,int end){

        if(start>end)
            return null;
        int i=0;
        Node node=new Node(a[end]);
        for(i=end-1;i>start;i--){
            if(a[i]<node.data){
               // max=i;
                break;
            }

        }
        node.left=createTree(a,start,i);
        node.right=createTree(a,i+1,end-1);
        return node;
    }

}
