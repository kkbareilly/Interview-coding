package BinaryTree;

public class DistanceBetweenNodes {

    public int calculateDistance(Node node,Node n1,Node n2){
      Node nodes=new LCA().lca(node,n1,n2);
      if(nodes==null){
          return -1;
      }
      int d1=distance(node,n1.data,0);
      int d2=distance(node,n2.data,0);
      return d1+d2;

    }

    public int distance(Node node ,int val,int dist){
        if(node==null)
            return -1;
        if(node.data==val)
            return dist;
        int d=distance(node.left,val,dist+1);
        if(d==-1){
            d=distance(node.right,val,dist+1);
        }
        return d;
    }
}
