package LeetCode.Leet150.dp.multiDimention;
//when array is circular
public class HouseRObberII {

public int robber11(int nums[]){
    if(nums.length<2)
        return nums[0];
    int skipEnd[]=new int[nums.length-1];
    int skipStart[]=new int[nums.length-1];
    for(int i=0;i<nums.length;i++){
        skipEnd[i]=nums[i];
        skipStart[i]=nums[i+1];
    }
    int lootedSkippingEnd=robberHelper(skipEnd);
    int lootedSkippingStart=robberHelper(skipStart);
    return Math.max(lootedSkippingEnd,lootedSkippingStart);
}



    public int robberHelper(int[]nums){
        if(nums.length<2)
            return nums[0];
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        dp[0]=Math.max(nums[0] ,nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
            return dp[nums.length-1];
    }
}
