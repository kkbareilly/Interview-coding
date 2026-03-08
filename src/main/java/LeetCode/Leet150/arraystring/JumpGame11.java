package LeetCode.Leet150.arraystring;

public class JumpGame11 {


    public int jump(int nums[]){
        int res=0;
        int left=0;
        int right=0;
        int farthest=0;
        while(right<nums.length-1){
            farthest=0;
            for(int i=left;i<right+1;i++){
                farthest=Math.max(farthest,i+nums[right]);
            }
            left=right+1;
            right=farthest;
            res+=1;
        }
        return res;
    }

    public int jumps(int[]num){
        int coverage=0;
        int destination=num.length-1;
        int lastJumpIndex=0;
        int jumps=0;
        if(num.length==1) return 0;
        for(int i=0;i<num.length;i++){
            coverage=Math.max(coverage,i+num[i]);
            if(i==lastJumpIndex){
                lastJumpIndex=coverage;
                jumps++;
            }
            if(coverage>=destination)
                return jumps;
        }
        return jumps;
    }
}
