package LeetCode.Leet150.dp;

public class LongestCommonIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        int[]result=new int[nums.length];

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(result[j]+1>result[i])
                        result[i]=result[j]+1;
                }
            }
        }

        int index=0;
        for(int i=0;i<result.length;i++){
            if(result[i]>result[index]){
                index=i;
            }
        }

        return result[index]+1;
    }


}
