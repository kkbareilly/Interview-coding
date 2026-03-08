package BinaryTree;

import java.util.ArrayList;

public class PrintAllPathForGivenSum {

ArrayList list=new ArrayList();

    public void kPath(Node node,int val){
        if(node==null)
            return;
        list.add(node.data);
        kPath(node.left,val);
        kPath(node.right,val);
        int sum=0;
        int i=0;
        for( i=list.size()-1;i>0;i--){
            sum=sum+(int)list.get(i);
            if(sum==val){
                for(int j=i;j<list.size();j++){
                    System.out.println(list.get(j));
                }
            }
        }
        list.remove(list.size()-1);
    }
}
