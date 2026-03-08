package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequestElement {

    public List<Integer>topKFrequency(int a[],int k){

        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<a.length;i++){
           map.put(a[i], map.getOrDefault(a[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap=new PriorityQueue<>(
                (n1,n2)->n1.getValue()-n2.getValue()
        );
        maxHeap.addAll(map.entrySet());
        List<Integer>result=new ArrayList<>();
        for (int i=0;i<k&&!maxHeap.isEmpty();i++){
            result.add(maxHeap.peek().getKey());
        }
        return result;
    }
}
