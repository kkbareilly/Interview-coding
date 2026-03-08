package LeetCode.Leet150.arraystring;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSortedArray {

    public static void main(String[] args){
        int num1[]={1,2,3,0,0,0};
        int num2[]={2,4,5};
    System.out.println(merge(num1,3,num2,3).toString());
    }


    public static int[] merge(int [] nums1,int m,int [] nums2,int n){

        int k=m+n-1;

        while(m>0 && n>0){
            if( nums1[m-1]>nums2[n-1]){
                nums1[k]=nums1[m-1];
                m--;
            }else{
                nums1[k]=nums2[n-1];
                n--;
            }
            k--;
        }
        while (n>0){
            nums1[k]=nums2[n-1];
            k++;
            n--;
        }
    Arrays.stream(nums1).forEach(a -> System.out.println(a));
      return nums1;
    }
}
