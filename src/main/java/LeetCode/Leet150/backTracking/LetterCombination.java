package LeetCode.Leet150.backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

    public List<String> letterCombination(String digits){
        List<String> result=new ArrayList<>();
        Map<Character,String>map=getMapping();
        if(digits.length()==0)
            return result;
    solve(0, digits, new StringBuilder(), result, map);
         return result;
    }

    public void solve(int i, String digits, StringBuilder s, List<String> result,Map<Character,String> mapping){
    if (i == digits.length()) {
      result.add(s.toString());
      return;
            }

    for(char c:mapping.get(digits.charAt(i)).toCharArray()){
      StringBuilder temp = new StringBuilder(s);
        temp.append(c);
        solve(i+1,digits,temp,result,mapping);
        temp.deleteCharAt(temp.length() - 1);


    }

    }

    public Map<Character,String>getMapping(){
        Map<Character,String>map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        return map;
    }




    List<String> result = new ArrayList<>();

    public void solve(int idx, String digits, StringBuilder temp, Map<Character, String> mp ){
        if(idx >= digits.length()){
            result.add(temp.toString());
            return;
        }


        char ch = digits.charAt(idx);
        String str = mp.get(ch);
        for (int i = 0; i < str.length(); i++){
            temp.append(str.charAt(i));
            solve(idx + 1 , digits, temp , mp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 ){
            return new ArrayList<>();
        }

        Map<Character , String> mp= new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        StringBuilder temp = new StringBuilder();

        solve(0 , digits, temp , mp);

        return result;
    }
}
