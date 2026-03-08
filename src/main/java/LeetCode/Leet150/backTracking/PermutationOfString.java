package LeetCode.Leet150.backTracking;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationOfString {


public static void main(String[] args){
    List<String>  result=new ArrayList<>();
    String s="aabc";
    permute(s,new String(),result);
    result.stream().forEach(sp->System.out.println(sp));

}
    public static void permute(String s, String output,List<String> result){

        if(StringUtils.isEmpty(s)){
            result.add(output);
            return;
        }
        Set<Character> valid=new HashSet<>();

        for(int i=0;i<s.length();i++){
            if(!valid.contains(s.charAt(i))){
                valid.add(s.charAt(i));
                String newInput=s.substring(0,i)+s.substring(i+1);
                String newOutPut=output+s.charAt(i);
                permute(newInput,newOutPut,result);
            }
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();

        backTrack(nums,new ArrayList<>(),result);
        return result;
    }
    public void backTrack(int nums[],List<Integer>temp,List<List<Integer>>result){

        if(temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int data:nums){
            if(temp.contains(data))
                continue;
            temp.add(data);
            backTrack(nums,temp,result);
            temp.remove(temp.size()-1);
        }
    }
}
