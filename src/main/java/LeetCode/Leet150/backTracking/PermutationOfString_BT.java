package LeetCode.Leet150.backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class PermutationOfString_BT {


public static void main(String[] args){
    List<String>  result=new ArrayList<>();
    String s="abc";
    BackTrack(s);//.stream().forEach(sp->System.out.println(sp));

}

public static List<String>BackTrack(String s){
    List<String>  result=new ArrayList<>();
    permute(s,0,result);
    return result;
}
    public static void permute(String s, int start,List<String> result){

        if(start==s.length()-1){
            result.add(s);
            return;
        }
        Set<Character> valid=new HashSet<>();

        for(int i=start;i<s.length();i++){
            if(!valid.contains(s.charAt(i))){
                valid.add(s.charAt(i));
               // s.replace()
                swap(s.charAt(start),s.charAt(i));
        System.out.println("after swap "+ s);
                permute(s,start+1,result);
                swap(s.charAt(start),s.charAt(i));
            }
        }
    }


    public static void swap(Character c,Character c1){
        Character t=c;
    c=c1;
    c1=t;
    }
}
