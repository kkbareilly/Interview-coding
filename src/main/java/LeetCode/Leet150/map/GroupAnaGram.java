package LeetCode.Leet150.map;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnaGram {

    public static void main(String[] args){
       int nums[] = {2,7,11,15};
       int ans[]=twoSum(nums,9);
      System.out.println(ans[0]+""+ans[1]);
    }

    public  List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map=new HashMap<>();
        if(strs==null || strs.length<=0)
            return null;
        for(String key:strs){

            String fre=getFrequency(key);
            if(map.containsKey(fre)){
                map.get(fre).add(key);
            }else{
                map.put(fre,new ArrayList<String>(){{add(key);}});
            }

        }
        return new ArrayList<>(map.values());
    }

    private  String getFrequency(String s){
        int[] freq = new int[26];
        for(Character c:s.toCharArray()){
            freq[c-'a']++;
        }
        char c='a';
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                stringBuilder.append(c).append(freq[i]);
            }
            c++;
        }
        return stringBuilder.toString();
    }

        public static int[] twoSum(int[] nums, int target) {
            Set<Integer> st=new HashSet();
            for(int i=0;i<nums.length;i++){
                if(st.contains(target-nums[i])){
                    return new int[]{nums[i],target-nums[i]};
                }else{
                    st.add(nums[i]);
                }
            }
            return new int[]{};
        }

}
