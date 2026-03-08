package LeetCode.Leet150.backTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> result=new ArrayList<>();
        buildCombination(candidates,0,target,new ArrayList<>(),result);
      return result;
    }

    private void buildCombination(int[]can,int start,int target, List<Integer> list, List<List<Integer>> result){
        if(target<0)
            return;
        if(target==0){
            result.add(new ArrayList(list));

        }

        for(int i=start;i<can.length;i++){
            list.add(can[i]);
            buildCombination(can,i,target-can[i],list,result);
            list.remove(list.size()-1);
        }
    }
}
