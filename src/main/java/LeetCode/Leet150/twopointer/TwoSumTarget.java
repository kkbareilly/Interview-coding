package LeetCode.Leet150.twopointer;

public class TwoSumTarget {

    public int[] sumTarget(int[] numbers, int target){
        if(numbers.length==0)
            return new int[]{};
        int spointer=0;
        int epointer=numbers.length-1;
        while (spointer<epointer){
            int sum=numbers[spointer]+numbers[epointer];
            if(sum<target){
                spointer++;
            }else if (sum>target){
                epointer--;
            }else {
                return new int[]{spointer+1,epointer+1};
            }
        }
        return new int[]{spointer+1,epointer+1};
    }
}
