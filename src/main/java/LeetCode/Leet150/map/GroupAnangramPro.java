package LeetCode.Leet150.map;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnangramPro {

    public static void main(String[] args){
      String[] strs = {"eat","tea","tan","ate","nat","bat"};
      groupAnagrams(strs).stream().flatMap(data->data.stream()).forEach(data->System.out.println(data));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {

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

    private static String getFrequency(String s){
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



    public List<List<String>> groupAnagramss(String[] strs) {
        /*
            Input: String array , all strings in lowercase letters
            Output: List of Group of anagrams

            What is angram? is word you can get by rearranging works of another word
            Example: eat -> ate, tae, ate....
            Lesson: if you sort the words alphabetically they will give the same string
        */
        Map<String, List<String>> anagrams = new HashMap();
        for(String s : strs) {
            char[] st = s.toCharArray();
            Arrays.sort(st);
            String sb = new String(st);

            List<String> lst = anagrams.getOrDefault(sb, new ArrayList());
            lst.add(s);
            anagrams.put(sb, lst);
        }

        return new ArrayList<>(anagrams.values());
    }
}
