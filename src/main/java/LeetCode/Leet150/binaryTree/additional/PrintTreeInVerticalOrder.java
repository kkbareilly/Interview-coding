package LeetCode.Leet150.binaryTree.additional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PrintTreeInVerticalOrder {
    Map<Integer, List<Node>> map=new TreeMap<>();
    public void vertical(Node node,Map<Integer,List<Node>> map,int level){
        if(node==null)
            return;
        if(!map.containsKey(level)){
            List<Node> data=new ArrayList();
            data.add(node);
            map.put(level,data);

        }else{
          map.get(level).add(node);
        }

        vertical(node.left,map,level-1);
        vertical(node.right,map,level+1);
    }
}
