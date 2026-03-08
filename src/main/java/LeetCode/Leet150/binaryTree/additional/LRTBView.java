package LeetCode.Leet150.binaryTree.additional;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class LRTBView {
    int maxLevel=0;
    public void left(Node node,int level){
    if(node==null)
       return;
    if(level>=maxLevel){
      System.out.println(node.data);
      maxLevel++;
    }
    left(node.left,level+1);
    left(node.right,level+1);

    }

    public void right(Node node,int level){
        if(node==null)
            return;
        if(level>=maxLevel){
            System.out.println(node.data);
            maxLevel++;
        }
        left(node.right,level+1);
        left(node.left,level+1);

    }

    public void topView(Node node){
        Map<Integer,Node>map=new TreeMap<>();
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node n=q.poll();
            if(map.get(n.height)==null){
                map.put(n.height,node);
            }
            if(n.left!=null){
                n.left.height-=1;
                q.add(n.left);
            }
            if(n.right!=null){
                n.right.height+=1;
                q.add(n.right);
            }
        }

    }

    public void topViewRecursive(Node node,TreeMap map,int level){
if(node==null)
    return;
   if(!map.containsKey(level)){
       map.put(level,node);
   }
        topViewRecursive(node.left,map,level-1);
        topViewRecursive(node.right,map,level+1);

    }

    public void bottomView(Node node, Map map, int level){
        if(node==null)
            return;

        map.put(level,node);
        bottomView(node.left,map,level-1);
        bottomView(node.right,map,level+1);
    }
    public void bottomView(Node node){
        Map<Integer,Node>map=new TreeMap<>();
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node n=q.poll();

                map.put(n.height,node);

            if(n.left!=null){
                n.left.height-=1;
                q.add(n.left);
            }
            if(n.right!=null){
                n.right.height+=1;
                q.add(n.right);
            }
        }

    }
}
