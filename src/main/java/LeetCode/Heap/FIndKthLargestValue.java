package LeetCode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FIndKthLargestValue {

    //using  max heap  time complexity will be o(n)+k*logn
    //using min heap klog k+(n-k)log k
    public static void main(String[] args) {
        int a[]={2,1,4,6,19,3};

        System.out.println(minHeap(a,3));
        System.out.println(maxHeap(a,3));

    }
public static int minHeap(int arr[],int k){

    if(arr.length<k)
        return -1;
    int j=0;
    PriorityQueue<Integer> queue=new PriorityQueue<>();
    while (j<k){
        queue.add(arr[j]);
        j++;
    }
    for(int i=k;i<arr.length;i++){

        if(arr[i]>queue.peek()){
            queue.poll();
            queue.add(arr[i]);
        }
    }
 return queue.peek();
}

    public static int maxHeap(int arr[],int k){

        if(arr.length<k)
            return -1;
        int j=0;
        PriorityQueue<Integer> queue=new PriorityQueue<>(Comparator.reverseOrder());
        while (j<arr.length){
            queue.add(arr[j]);
            j++;
        }
        for(int i=0;i<k-1;i++){

                queue.poll();

        }
        return queue.peek();
    }
}
