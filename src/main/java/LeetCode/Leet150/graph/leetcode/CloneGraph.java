package LeetCode.Leet150.graph.leetcode;

import java.util.*;

public class CloneGraph {



    public Node clonegrp(Node node){
        if(node==null)
            return node;
        Queue<Node> q=new LinkedList();
        q.add(node);
        Map<Node,Node>map=new HashMap<>();
        map.put(node,new Node(node.val));
        while (!q.isEmpty()){
            Node current=q.poll();
            for(Node ng:current.neighbours){
            if(!map.containsKey(ng.val)){
                map.put(ng,new Node(ng.val));
                q.add(ng);
            }
            if(map.get(current)!=null)
            map.get(current).neighbours.add(map.get(ng.val));
            }
        }

      return map.get(node);
    }
    public Node cloneGraph(Node node, Map<Node,Node> map){
        if(node==null)
            return null;
        if(map.containsKey(node)){
            return node;
        }
            Node copy=new Node(node.val);
            map.put(node,copy);

        for(Node nm:node.neighbours){
            copy.neighbours.add(cloneGraph(nm,map));
        }
        return copy;
    }
}
class Node{
    int val;
    List<Node> neighbours;
    Node(int val){
        this.val=val;
        neighbours=new ArrayList<>();
    }
}