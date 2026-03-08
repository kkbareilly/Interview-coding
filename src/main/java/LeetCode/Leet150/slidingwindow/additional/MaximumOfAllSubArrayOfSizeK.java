package LeetCode.Leet150.slidingwindow.additional;

import java.util.*;

public class MaximumOfAllSubArrayOfSizeK {

    public static void main(String[] args) {
        int a[]={3,1,-1,2,5};
        getMax(a,3).forEach(e->System.out.println(e));
    }
    public static List getMax(int []a,int k)
    {

        int j=0;
        int i=0;
        ArrayList list=new ArrayList();
        PriorityQueue pq=new PriorityQueue(Collections.reverseOrder());
        while (j<a.length){
               pq.add(a[j]);
            if(j-i+1<k){
                j++;
            } else if(j-i+1==k){
                list.add(pq.peek());
                pq.remove(a[i]);
                i++;
                j++;
            }

        }
        return list;
    }}
