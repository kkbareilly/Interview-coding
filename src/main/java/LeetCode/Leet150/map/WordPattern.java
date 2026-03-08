package LeetCode.Leet150.map;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
public static void main(String[] args){
    System.out.println(pattern("abba","dog cat cat dog"));
}
    public static  boolean pattern(String pattern, String s){
        String words[]=s.split(" ");
        if(pattern.length()!=words.length)
            return false;
        Map<Character,String> map=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                 if(!map.get(pattern.charAt(i)).equals(words[i])){return false;}
            }else{
                if(map.containsValue(words[i]))
                     return false;
           map.put(pattern.charAt(i),words[i]);
            }
        }
       return true;
    }
}
