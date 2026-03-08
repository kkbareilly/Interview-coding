package LeetCode.Leet150.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    public String minWindow(String s, String t) {
        if(s==null || t==null)
            return "";
        Map<Character,Integer>countT=new HashMap<>();
        Map<Character,Integer>window=new HashMap<>();
        for(int i=0;i<t.length();i++){
            countT.put(t.charAt(i),countT.getOrDefault(t.charAt(i),0)+1);
        }
        int have=0;
        int need=t.length();
        int result[]=new int[2];
        int resultLen=Integer.MAX_VALUE;
        int left=0;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            if(countT.containsKey(c)&& countT.get(c)==window.get(c)){
                have+=1;
            }
            while (have==need){
                if(right-left+1<resultLen){
                    result=new int[]{left,right};
                    resultLen=right-left+1;
                }
                char leftchar=s.charAt(left);
                window.put(leftchar,window.getOrDefault(leftchar,0)-1);
              if(countT.containsKey(leftchar) &&window.get(leftchar)<countT.get(leftchar)){
                  have-=1;
              }
             left++;
            }
        }
        if(resultLen==Integer.MAX_VALUE) return "";
        else return s.substring(result[0],result[1]+1);
    }
}
