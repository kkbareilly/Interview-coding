package LeetCode.Leet150.interval;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SummaryRange {

    public List<String> summaryRanges(int[] nums) {
     List<String> result=new ArrayList<>();

     for(int i=0;i<nums.length;i++){
         int start=nums[i];
         while(i+1<nums.length&&nums[i+1]==nums[i]+1){
             i++;
         }
         if(nums[i]!=start){
             result.add(""+start+"->"+nums[i]);
         }else
             result.add(""+start);
     }
     return result;
    }

  public  int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
            return intervals;
    Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));
        List<int[]>result=new ArrayList<>();
        int newInterwal[]=intervals[0];
        result.add(newInterwal);
        for(int interwal[]:intervals){
            if(interwal[0]<=newInterwal[1]){
                newInterwal[1]=Math.max(newInterwal[1],interwal[1]);

            }else{
                newInterwal=interwal;
                result.add(newInterwal);
            }
        }
        return result.toArray(new int[result.size()][]);
  }
    }
