package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsk {

    public static void main(String[] args) {
        int result=0;
        int k=15;
        int sum=0;
        Map map=new HashMap<>();
        map.put(0,1);
        int a[]={};
        for(int i=0;i<a.length;i++){
              sum+=a[i];
              if(map.containsKey(sum-k)){
                  result+=(int)map.get(sum-k);
              }
              map.put(sum,(int)map.getOrDefault(sum,0)+1);
        }
    }
}
