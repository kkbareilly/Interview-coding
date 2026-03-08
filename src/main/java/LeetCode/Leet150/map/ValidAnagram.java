package LeetCode.Leet150.map;

public class ValidAnagram {


    public static void main(String[] args){

    }

    public static boolean isValid(String s,String t){
        if(s.length()!=t.length())
             return false;
        char char_a[]=new char[26];
        for (int i=0;i<s.length();i++){
            char_a[s.charAt(i)-'a']++;
            char_a[t.charAt(i)-'a']--;
        }
        for (int i=0;i<char_a.length;i++){
            if(char_a[i]!=0)
                return false;
        }
        return true;
    }
}
