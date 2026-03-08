package LeetCode;

public class Jump {

//Jump game II
    public int solve(int a[]){

        int n=a.length;
         int jums=1;
        if(a[0]==0 || n==1)
            return 0;
        int curr_end=a[0];
        int forthest=a[0];
        for(int i=1;i<n;i++){

            if(i==n-1)
                return jums;
            forthest=Math.max(forthest,i+a[i]);
            if(curr_end==i){
                jums++;
                curr_end=forthest;
            }
        }
        return jums;
    }

//jump Game

    public boolean isJumpPossible(int a[]){
        int lastPossiblePosition=a.length-1;
        for(int i=a.length-1;i>0;i--){
            if(i+a[i]>=lastPossiblePosition){
                lastPossiblePosition=i;
            }
        }
         return lastPossiblePosition==0;
    }

}