package LeetCode.Leet150.slidingwindow.additional;

import java.util.*;

public class FirstNegativeNumberInSizeK {

    public List<Integer> getNegativeNumbers(int []a,int k){

        int i=0;int j=0;
        Deque<Integer> que=new LinkedList();
        List<Integer> result=new ArrayList<>();

        while (j<a.length){
            que.addLast(a[j]);
            if(j-i+1<k){
                j++;
                }else if(j-i+1==k){
              Iterator it= que.iterator();
                 while (it.hasNext()){
                     int data=(int)it.next();
                     if(data<0){
                         result.add(data);
                     }
                 }
                 que.removeFirst();
                }

        }
        return result;

    }
}
