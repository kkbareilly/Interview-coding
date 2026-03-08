package LeetCode.String;

import java.util.Arrays;

public class PermutationInString {

  /*  Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

    In other words, return true if one of s1's permutations is the substring of s2.*/
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        //Character frequency count of each string
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        //Store s1 character frequencies in array
        for(char c : s1.toCharArray())
            count1[c - 'a']++;
        //Iterate through s2 string
        int left = 0;
        for(int right = 0; right < len2; right++){
            //Store s2 character frequencies in array
            count2[s2.charAt(right) - 'a']++;
            //Slide window if range is greater than s1 length
            while(right - left + 1 > len1){
                //Decrement frequency of characters out of window range
                count2[s2.charAt(left) - 'a']--;
                left++;
            }
            //s2 substring contains a permutation of s1
            if(Arrays.equals(count1, count2))
                return true;
        }
        //Found no permutations of s1 within s2
        return false;
    }
}
