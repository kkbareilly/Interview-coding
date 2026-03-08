package LeetCode.Heap;

import java.util.PriorityQueue;

public class KthLargestInStream {
    PriorityQueue<Integer> queue=new PriorityQueue();
    public int add(int num,int k){
        if(queue.size()<k){
            queue.add(num);
            return queue.size()==k?queue.peek():-1;
        }
        if (num>queue.peek()){
            queue.poll();
            queue.add(num);
        }
        return queue.peek();
    }

}
