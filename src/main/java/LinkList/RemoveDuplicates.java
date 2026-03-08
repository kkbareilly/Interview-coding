package LinkList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicates {



    public static void removeDuplicate(Node root){

        Set map=new HashSet();
        Node cur=root;
        Node pre=null;

        while (cur!=null){
            int val=cur.data;
            if(map.contains(val)){
                pre.next=cur.next;
            }else{
                map.add(val);
                pre=cur;
            }
            cur=cur.next;
        }
    }

    public static  Node removeRecursive(Node node){
        if(node!=null && node.next!=null)
            return node;
    if (node.data == node.next.data) {
      node.next = node.next.next;
      removeRecursive(node);
        }else{
        removeRecursive(node.next);
    }
    return node;
    }
}


