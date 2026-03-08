package LeetCode.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapUsingJavaLibrary {
    public static void main(String[] args) {
        int a[]={2,1,4,6,19,3};
        System.out.println(maxHeap(a));
    }
    public static int minHeap(int arr[]){
     //default is mean heap
        PriorityQueue<Integer> que=new PriorityQueue();
        for(int i=0;i<arr.length;i++){
            que.add(arr[i]);
        }
        return que.poll();
    }

    public static int maxHeap(int arr[]){
        //default is mean heap
        PriorityQueue<Integer> que=new PriorityQueue(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            que.add(arr[i]);
        }
        return que.poll();
    }
}
