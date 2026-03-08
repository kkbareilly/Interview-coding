package BinarySearchTree;

public class InorderPredecessor {
    Node inorderPredecessor=null;
    public Node preDecessor(Node node,int val){
        if(node==null)
            return null;
        while (node!=null){
        if(val<node.data){
            node=node.left;
        }else if(val>node.data){
          inorderPredecessor=node;
          node=node.right;
        }else {
            if(node.left!=null){
                inorderPredecessor=getPredecessor(node);
            }
            break;
        }
        }
        return node!=null?inorderPredecessor:null;
    }

    public Node getPredecessor(Node node){
        if(node!=null);
       Node  temp=node.left;
        while (temp.right!=null){
            temp=temp.right;
        }
        return temp;
    }
}
