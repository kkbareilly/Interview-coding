package LeetCode.Arrays;

import java.util.LinkedList;

public class SlidingWindow {



    public int[] maxValue(int [] a,int k){
        int n=a.length;
        int ans[]=new int[n-k+1];
        LinkedList<Integer> list=new LinkedList();
       int index=0;
        for(int i=0;i<n;i++){

            while (!list.isEmpty() && list.getLast()<a[i]){
                list.pollLast();
            }

            list.add(a[i]);
            if(i>=k-1){
                ans[index++]= list.pollFirst();
                if(list.peekFirst()==a[i-k+1])
                    list.pollFirst();
            }
        }

      return ans;
    }
}
