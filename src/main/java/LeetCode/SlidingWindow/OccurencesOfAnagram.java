package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class OccurencesOfAnagram {
  public static void main(String[] args) {
    //
      String s="aabaabaacaaab";
      String p="aaba";
    System.out.println(anagram(s,p));
  }

    public static int anagram(String s,String p){

        int i=0;
        int j=0;
        int count=0;
        int result=0;
        int k=p.length();
        Map<Character,Integer> anangram=new HashMap<>();
        for(Character c:p.toCharArray()){
            if(anangram.containsKey(c)){
                anangram.put(c,anangram.get(c)+1);
            }else {
                anangram.put(c,1);
            }
        }
         count=anangram.size();
        while (j<s.length()){
            if(anangram.containsKey(s.charAt(j))){
                anangram.put(s.charAt(j),anangram.get(s.charAt(j))-1);
            }
            if(anangram.containsKey(s.charAt(j)) &&anangram.get(s.charAt(j))==0){
                count--;
            }
            if(j-i+1<k){
                j++;
            }
         /*   if(i==0 && j-i+1==k){
                if(anangram.containsKey(s.charAt(j))){
                    anangram.put(s.charAt(j),anangram.get(s.charAt(j))-1);
                }
                if(anangram.containsKey(s.charAt(j)) &&anangram.get(s.charAt(j))==0){
                    count--;
                }
            }*/
           else if(j-i+1==k){

                if(count==0){
                   result++;
                }
                if(anangram.containsKey(s.charAt(i))){
                    anangram.put(s.charAt(i),anangram.get(s.charAt(i))+1);
                    count++;
                }else{

                }
                i++;
                j++;
            }
        }
        return result;
    }
}
