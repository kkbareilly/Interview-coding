package LeetCode.Leet150.backTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumWithoutRepeatingNumber {

    public List<List<Integer>> combinationSum(int k, int n) {
      List<List<Integer>> result=new ArrayList<>();
    buildCombination(1, k, n, new ArrayList<Integer>(), result);
      return result;
    }

    private void buildCombination(int i,int k,int n, List<Integer> list, List<List<Integer>> result){
        if(k==0 && n==0)
            list.add(i);
        if(i>9){
            return;
        }

        if(k<0 || n<0)
            return;
        ArrayList<Integer> temp=new ArrayList();
        temp.add(i);
        buildCombination(i+1,k-1,n-1,temp,result);
        buildCombination(i+1,k,n,list,result);

    }
}
