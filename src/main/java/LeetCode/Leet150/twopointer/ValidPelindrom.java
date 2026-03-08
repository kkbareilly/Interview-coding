package LeetCode.Leet150.twopointer;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public class ValidPelindrom {



    public boolean isValidPelindrom(String s){
        if(StringUtils.isEmpty(s))
            return true;
        String fixString="";
        for(Character c :s.toCharArray()){
            if(Character.isDigit(c)|| Character.isLetter(c)){
                fixString+=c;
            }
        }
        fixString=fixString.toLowerCase();

        int start=0;
        int end=fixString.length()-1;

        while (start<end){
            if(fixString.charAt(start)!=fixString.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
