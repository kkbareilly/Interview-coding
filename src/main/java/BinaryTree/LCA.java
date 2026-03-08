package BinaryTree;

public class LCA {


    public Node lca(Node node,Node n1,Node n2){
        if(node==null)
            return null;
        if(n1==null && n2==null)
            return null;
        if(n1==null || n2==null)
            return null;
          if(node.data==n1.data || node.data==n2.data){
              return node;
          }
               Node left=lca(node.left,n1,n2)  ;
                Node right=lca(node.right,n1,n2)  ;
        if(left==null && right==null)
            return null;
        if(left!=null && right!=null)
            return node;
        return left!=null?left:right;
    }

}
