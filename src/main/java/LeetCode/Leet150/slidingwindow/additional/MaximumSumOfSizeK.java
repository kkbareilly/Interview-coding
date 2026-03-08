package LeetCode.Leet150.slidingwindow.additional;

public class MaximumSumOfSizeK {
    public static void main(String[] args) {
        int a[]={1, 4, 2, 10, 23, 3, 1, 0, 20};
        System.out.println(maxSum(a,4));
    }
    public static int maxSum(int a[],int k){
        int max=0;
        int i=0;int j=0;
        int sum=0;
        while (j<a.length){
            sum+=a[j];
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
              max=Math.max(sum,max);
              sum=sum-a[i];
              i++;
              j++;
            }
        }
        return max;
    }
}
