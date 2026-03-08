package LeetCode.Leet150.kadensAlgo;

public class MaximumSumCcontigusSubArray {

    public int maxSum(int[]arr){

        int current_max=arr[0];
        int max_so_for=arr[0];
        for(int i=1;i<arr.length;i++){
            current_max=Math.max(arr[i],arr[i]+current_max);
            max_so_for=Math.max(max_so_for,current_max);
        }
        return max_so_for;
    }
}
