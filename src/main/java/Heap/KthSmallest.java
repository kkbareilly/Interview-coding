package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {

    public int smallest(int a[],int k){
        if(a.length<k)
            return -1;
        PriorityQueue<Integer> maxHeap=new PriorityQueue(Comparator.reverseOrder());
   for(int i=0;i<k;i++)
       maxHeap.add(a[i]);

   for(int j=k;j<a.length;j++){
       if(a[j]<maxHeap.peek()){
           maxHeap.poll();
           maxHeap.add(a[j]);
       }
   }
   return maxHeap.peek();
    }
}
