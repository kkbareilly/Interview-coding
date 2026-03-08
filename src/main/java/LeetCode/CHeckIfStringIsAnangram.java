package LeetCode;

public class CHeckIfStringIsAnangram {
    public static void main(String[] args) {
        String s1="test";
        String s2="etst";
        System.out.println(isAnagram(s1,s2));
    }


    public  static boolean isAnagram(String s1,String s2){

        if(s1.length()!=s2.length())
            return false;
        int a[]=new int[26];
        for(int i=0;i<s1.length();i++){
            a[s1.charAt(i)-'a']++;
            a[s2.charAt(i)-'a']--;

        }

        for(Integer data:a){
            if(data!=0)
                return false;
        }
        return true;
    }
}
