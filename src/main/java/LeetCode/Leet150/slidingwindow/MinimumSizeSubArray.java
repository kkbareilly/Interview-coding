package LeetCode.Leet150.slidingwindow;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubArray {

    public int minSubArrayLen(int target, int[] nums) {
       int left=0;
       int total=0;
       int result=Integer.MAX_VALUE;
       for(int right=0;right<nums.length;right++){
           total+=nums[right];
           while (total>=target){
               result=Math.min(result,right-left+1);
               total-=nums[left];
               left++;
           }
       }
       if(result==Integer.MAX_VALUE)
           return 0;
       else
           return result;
    }
}
