package BinarySearchTree;

public class PreOrderToBST {




    public Node createTree(int [] a,int start,int end){

        if(start>end)
            return null;
        int i=0;
        Node node=new Node(a[start]);
        for(i=start+1;i<end;i++){
            if(a[i]>node.data){
               // max=i;
                break;
            }

        }
        node.left=createTree(a,start+1,i-1);
        node.right=createTree(a,i,end);
        return node;
    }

}
