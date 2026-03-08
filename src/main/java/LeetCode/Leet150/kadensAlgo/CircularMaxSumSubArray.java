package LeetCode.Leet150.kadensAlgo;

public class CircularMaxSumSubArray {

    public int maxSum(int []arr){
        int globalMax=arr[0];
        int globalMin=arr[0];

        int currentMax=0;
        int currentMin=0;
        int total=0;

        for (int i=0;i<arr.length;i++){
            currentMax=Math.max(currentMax+arr[i],arr[i]);
            currentMin=Math.min(currentMin+arr[i],arr[i]);
            total+=arr[i];
            globalMax=Math.max(globalMax,currentMax);
            globalMin=Math.min(globalMin,currentMin);

        }
        if(globalMax>0){
            return Math.max(globalMax,total-globalMin);
        }else {
            return globalMax;
        }

    }

    int total;

    public int maxSubarraySumCircular(int[] nums) {
        int max = kadanes(nums, true);
        int min = kadanes(nums, false);

        // If the maximum is greater than 0, return the maximum of max or total - min
        return max > 0 ? Math.max(max, total - min) : max;
    }

    private int kadanes(int[] nums, boolean isMax) {
        total = 0;

        int current = 0;
        int sum = nums[0];

        for (int num : nums) {
            total += num;

            if (isMax) {
                // Calculate maximum subarray sum
                current = Math.max(current + num, num);
                sum = Math.max(sum, current);
            } else {
                // Calculate minimum subarray sum
                current = Math.min(current + num, num);
                sum = Math.min(sum, current);
            }
        }
        return sum;
    }
}
