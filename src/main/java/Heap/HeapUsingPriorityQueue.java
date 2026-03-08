package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapUsingPriorityQueue {
    public static void main(String[] args) {
        int a[]={10,7,11,5,2,13,1};
        minHeap(a);
    }
    public static void minHeap(int arr[]){
        PriorityQueue heap=new PriorityQueue();

        for (int i=0;i<arr.length;i++){
            heap.add(arr[i]);
            System.out.println(heap.peek());
        }
        for (int i=0;i<arr.length;i++){
            heap.poll();
            System.out.println(heap.peek());
        }
    }

    public static void maxHeap(int arr[]){
        PriorityQueue heap=new PriorityQueue(Comparator.reverseOrder());

        for (int i=0;i<arr.length;i++){
            heap.add(arr[i]);
            System.out.println(heap.peek());
        }
        for (int i=0;i<arr.length;i++){
            heap.poll();
            System.out.println(heap.peek());
        }
    }
}
