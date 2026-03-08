package LeetCode.Leet150.slidingwindow;
/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        int a_ponter=0;
        int b_pointer=0;
        int result=0;
        Set<Character> set=new HashSet<>();
        while (b_pointer<s.length()){
            if(!set.contains(s.charAt(b_pointer))){
                set.add(s.charAt(b_pointer));
                result=Math.max(result,set.size());
                b_pointer++;
            }else {
                set.remove(s.charAt(a_ponter));
                a_ponter++;
            }
        }
        return result;
    }
}
