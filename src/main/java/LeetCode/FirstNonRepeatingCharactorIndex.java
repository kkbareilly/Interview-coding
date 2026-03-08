package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharactorIndex {
   static Map<Character,Integer> map=new HashMap<>();

    public static Character solve(String str){
        for (int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),-1);
            }else {
                map.put(str.charAt(i),i);
            }
        }
     return null;
    }
}
