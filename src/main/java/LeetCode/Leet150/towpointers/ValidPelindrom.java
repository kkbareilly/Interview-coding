package LeetCode.Leet150.towpointers;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public class ValidPelindrom {

    public boolean isPalindrome(String s) {
        if(s==null || StringUtils.isEmpty(s))
            return true;
        String fix_string="";
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)|| Character.isLetter(ch))
                 fix_string+=ch;
        }
        fix_string=fix_string.toLowerCase();
        int start_p=0;int end_p=fix_string.length();
        while (start_p<=end_p){
            if(fix_string.charAt(start_p)!=fix_string.charAt(end_p)){
                return false;
            }
            start_p++;
            end_p--;
        }
        return true;
    }
}
