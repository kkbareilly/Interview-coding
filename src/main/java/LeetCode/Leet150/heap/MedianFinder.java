package LeetCode.Leet150.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> minheap=new PriorityQueue<>();
    Queue<Integer> maxheap=new PriorityQueue<>((a,b)-> b-a);

   int size=0;
    public MedianFinder() {

    }

    public void addNum(int num) {
        size++;
     if(maxheap.isEmpty() || maxheap.peek()>=num){
         maxheap.add(num);
     }else{
         minheap.add(num);
     }
     if(maxheap.size()>minheap.size()+1){
         Integer element=maxheap.poll();
         minheap.add(element);
     }else if(minheap.size()>maxheap.size()){
         Integer element=minheap.poll();
         maxheap.add(element);
     }
    }

    public double findMedian() {
       if(size%2!=0)
           return  (double)maxheap.peek();
       return (maxheap.peek()+minheap.peek())/2.0;
    }
}
