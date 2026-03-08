package LeetCode.SlidingWindow;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        int a[]={1, 4, 2, 10, 23, 3, 1, 0, 20};
        System.out.println(maxSum(a,4));
    }
    public  static int maxSum(int arr[],int k){

        int i=0;
        int j=0;
        int sum=0;
        int max=0;
        while (j<arr.length){
            sum=sum+arr[j];

            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                max=Math.max(max,sum);
                sum=sum-arr[i];
                i++;
                j++;
            }

        }
        return max;
    }
}

