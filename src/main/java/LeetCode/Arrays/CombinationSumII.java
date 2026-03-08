package LeetCode.Arrays;

import java.lang.reflect.Array;
import java.util.*;

public class CombinationSumII {
  public static void main(String[] args) {
    //
      List<List<Integer>> result=new ArrayList<>();
      int can[]={2,3,6,7};
    Arrays.parallelSort(can);
      buildCombination(can,0,7,new ArrayList<>(),result);
    result.stream().flatMap(a -> a.stream()).forEach(ts -> System.out.println(ts));
  }

    public static void buildCombination(int can[],int start,int target,List<Integer>list,List<List<Integer>>result){
        if(target<0)
            return ;
        if(target==0)
            result.add(new ArrayList<Integer>(list));

        for(int i=start;i<can.length;i++){
            if(i==start || can[i]!=can[i-1]){
            list.add(can[i]);
            buildCombination(can,i+1,target-can[i],list,result);
            list.remove(list.size()-1);
        }
        }
    }
}
