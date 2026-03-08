package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithoutrepetingCharacter {

    public static void main(String[] args) {
        char[]a={'b','w','w','k','e','w'};
        System.out.println(longest(a));
    }
    public static int longest(char[]a){

        int j=0;
        int i=0;
        int max=0;
        Map<Character,Integer> data=new HashMap<>();
        while (j<a.length){
            if(!data.containsKey(a[j])){
                data.put(a[j],1);
            }else{
                data.put(a[j],data.get(a[j])+1);
            }
           if(data.size()==j-i+1){
                if(max<data.size()){
                    max=data.size();
                }
                j++;
            }else if(data.size()<j-i+1){
                while (data.size()<j-i+1 && i<a.length){
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
