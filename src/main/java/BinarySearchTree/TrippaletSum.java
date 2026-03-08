package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class TrippaletSum {

    List<Integer> inordered=new ArrayList<>();
    public void inorderTraverse(Node node){
        if(node==null)
            return;
        inorderTraverse(node.left);
         inordered.add(node.data);
        inorderTraverse(node.right);

    }
    public boolean isTripplet(int sum,Node node){
        for(int i=0;i<inordered.size()-2;i++){
            int start=i+1;
            int end=inordered.size()-1;
            while (start<end){
                int result=inordered.get(i)+inordered.get(start)+inordered.get(end);
                if(result==sum)
                    return true;
                if (result<sum)
                    start++;
                if (result>sum)
                    end--;
            }
        }
        return false;
    }
}
