package BinaryTree;

import java.util.*;

public class PrintVerticalTree {
    public static void main(String[] args) {
        Map<Integer,List<Node>> map=new HashMap<>();
        vertical(Node.buildTree(),map,0);
        map.forEach((k,v)->{
            v.forEach(data->{
                System.out.print(data.data+"  ");
            });
            System.out.println("  ");

        });
    }

    private static void vertical(Node node, Map<Integer, List<Node>> map, int level){

        if(node==null)
            return;;

            if(map.containsKey(level)){
                List l=map.get(level);
                l.add(node);
                        map.put(level,l);
            }else {
                List l=new ArrayList();
                l.add(node);
                map.put(level,l);
            }
            vertical(node.left,map,level-1);
            vertical(node.right,map,level+1);



    }
}
