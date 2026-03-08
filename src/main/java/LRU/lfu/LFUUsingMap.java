package LRU.lfu;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUUsingMap {
    Map<Integer,Integer> cache=new HashMap<>();
    Map<Integer,Integer> keyCount=new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> freqMap=new HashMap<>();
int capacity;
int min=-1;

    LFUUsingMap(int capacity){
        this.capacity=capacity;
        freqMap.put(1,new LinkedHashSet<>());
    }

    public int get(int key){
       if(!cache.containsKey(key)) return -1;
      int count= keyCount.get(key);
      freqMap.get(count).remove(key);
      if(count==min && freqMap.size()==0) min++;
      if(!freqMap.containsKey(count+1)){
          freqMap.put(count+1,new LinkedHashSet<>());

      }
      freqMap.get(count+1).add(key);
      return cache.get(key);
    }

    public void put(int key, int value){
        if(capacity<=0) return;
        if(cache.containsKey(key)){
            cache.put(key,value);
            get(key);
            return;
        }
        if(cache.size()>=capacity){
            int evict=freqMap.get(min).iterator().next();
            freqMap.get(min).remove(evict);
            cache.remove(evict);
            keyCount.remove(evict);
        }
        cache.put(key,value);
        keyCount.put(key,1);
        min=1;
        freqMap.get(1).add(key);
    }
}
