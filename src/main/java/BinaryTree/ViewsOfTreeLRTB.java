package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ViewsOfTreeLRTB {
    int  maxLevel=0;


    //       10
    //    9          20
    //  5        8 18        22
    public static void main(String[] args) {
        ViewsOfTreeLRTB v=new ViewsOfTreeLRTB();
       // v.leftView(Node.buildTree(),0);
        System.out.println("right view ");
Map<Integer,Node> map=new HashMap<Integer, Node>();
      //  v.rightView(Node.buildTree(),0);

       // v.topView(Node.buildTree(),map,0);
         v.bottomView(Node.buildTree(),map,0);
map.forEach((k,val)->{System.out.println(val.data);});
    }
    public  void leftView(Node root,int level){
        if(root==null)
            return ;
        if(level>=maxLevel) {
            System.out.println(root.data);
            maxLevel++;
        }
        leftView(root.left,level+1);
        leftView(root.right,level+1);

    }

    public  void rightView(Node root,int level){

        if(root==null)
            return ;
        if(level>=maxLevel) {
            System.out.println(root.data);
            maxLevel++;
        }
        rightView(root.right,level+1);
        rightView(root.left,level+1);

    }


    public void topView(Node node, Map map,int level){
        if(node==null)
            return;

        if(!map.containsKey(level)){
            map.put(level,node);
        }
        topView(node.left,map,level-1);
        topView(node.right,map,level+1);
    }



    public void bottomView(Node node, Map map,int level){
        if(node==null)
            return;

        map.put(level,node);
        bottomView(node.left,map,level-1);
        bottomView(node.right,map,level+1);
    }
}
