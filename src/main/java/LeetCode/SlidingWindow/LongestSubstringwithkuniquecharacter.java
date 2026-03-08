package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
public class LongestSubstringwithkuniquecharacter {
    public static void main(String[] args) {
        char[]a={'a','a','b','c','a','a','a','d','d','c','c','c','c'};
        System.out.println(longest(a,3));
    }
    public static int longest(char[]a,int k){

        int j=0;
        int i=0;
        int max=0;
        Map<Character,Integer>data=new HashMap<>();
        while (j<a.length){
            if(!data.containsKey(a[j])){
                data.put(a[j],1);
            }else{
                data.put(a[j],data.get(a[j])+1);
            }
            if(data.size()<k){
                j++;
            }else if(data.size()==k){
                 if(max<getCount(data)){
                     max=getCount(data);
                 }
                 j++;
            }else if(data.size()>k){
                while (data.size()>k && i<a.length){
                    if(data.containsKey(a[i])){
                        if(data.get(a[i])==1){
                            data.remove(a[i]);
                        }else {
                            data.put(a[i], data.get(a[i]) - 1);
                        }
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }
    private static int getCount(Map<Character,Integer>map){
      int count=  map.entrySet().stream().mapToInt(p->
        {
            return p.getValue();
        }).sum();
      return count;
    }
}
