package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalSumofTree {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        vertical(Node.buildTree(),map,0);
        map.forEach((k,v)->{

            System.out.println("value  "+v);

        });
    }

    private static void vertical(Node node, Map<Integer, Integer> map, int level){

        if(node==null)
            return;;

            if(map.containsKey(level)){
                Integer l=map.get(level);
               l= l+node.data;
                        map.put(level,l);
            }else {
                map.put(level,node.data);
            }
            vertical(node.left,map,level-1);
            vertical(node.right,map,level+1);



    }
}
