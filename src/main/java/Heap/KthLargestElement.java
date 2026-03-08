package Heap;

import java.util.PriorityQueue;

public class KthLargestElement {


    public int kthLargest(int[]a,int k){
        if(a.length>k)
            return -1;
        PriorityQueue<Integer> heap=new PriorityQueue();
        for(int i=0;i<k;i++){
            heap.add(a[i]);
        }

        for (int j=k;j<a.length;j++){
            if(a[j]> heap.peek()){
                heap.poll();
                heap.add(a[j]);
            }
        }
        return heap.poll();
    }
}
