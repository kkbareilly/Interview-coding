package LeetCode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthSmallest {
    public static void main(String[] args) {
        int a[]={2,1,-1,4,6,19,3};
System.out.println(maxHeap(a,3));
    }
    public static int maxHeap(int a[],int k){
        PriorityQueue<Integer>q=new PriorityQueue<>(Comparator.reverseOrder());
        if(a.length<k)
            return -1;
        for(int i=0;i<k;i++)
            q.add(a[i]);
        for(int j=k;j<a.length;j++){
            if(a[j]<q.peek()){
                q.poll();
                q.add(a[j]);
            }
        }
        return q.peek();
    }
}
