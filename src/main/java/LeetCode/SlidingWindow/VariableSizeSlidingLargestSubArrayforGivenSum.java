package LeetCode.SlidingWindow;

import java.util.HashMap;

public class VariableSizeSlidingLargestSubArrayforGivenSum {

    public static void main(String[] args) {
        int a[]={4,1,1,1,2,3,2,1,1,1,1,-1,1,1};
        System.out.println(largest(a,5));
    }
public static int largest(int[]a,int k){

    int i=0;
    int j=0;
    int sum=0;
    int max=0;
    while (j<a.length){
        sum=sum+a[j];
       if(sum<k) {
           j++;
       } else if(sum==k){
           if(j-i+1>max)
               max=j-i+1;
           j++;
       }
      else if (sum>k){
           while (sum>k && i<a.length) {
               sum = sum-a[i];
                ++i;
               /*if(sum==k){
                   max = Math.max(max,(j-i+1));
               }*/
           }
           j++;
       }
    }
    return max;
}
    public static int largests(int[]arr,int k){

        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;

        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum == k){
                max = Math.max(i+1 , max);
            }
            else if(map.containsKey(sum-k)){
                max = Math.max(i-map.get(sum-k) , max);
            }
            if(!(map.containsKey(sum))){
                map.put(sum, i);

            }
        }

        return max;
    }

}


