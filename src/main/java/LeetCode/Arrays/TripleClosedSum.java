package LeetCode.Arrays;

public class TripleClosedSum {



    public int clogest(int[] a,int target){
        int result=a[0]+a[1]+a[a.length-1];
        int current_sum=0;
        for(int i=0;i<a.length-2;i++){
            int j=i+1;
            int k=a.length-1;
            while (j<k){
                current_sum=a[i]+a[j]+a[k];
                if(current_sum<target)
                    j++;
                else
                    k--;
            }
            if(Math.abs(current_sum-target)<Math.abs(result-target)){
                result=current_sum;
            }
        }
        return result;
    }
}
