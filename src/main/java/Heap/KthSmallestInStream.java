package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInStream {

    public int smallest(int num,int k){
        PriorityQueue<Integer> maxHeap=new PriorityQueue(Comparator.reverseOrder());
        if(maxHeap.size()<k){
            maxHeap.add(num);
            return maxHeap.size()==k?maxHeap.peek():-1;
        }
        if(num<maxHeap.peek()){
            maxHeap.poll();
            maxHeap.add(num);
        }
        return maxHeap.poll();
    }
}
