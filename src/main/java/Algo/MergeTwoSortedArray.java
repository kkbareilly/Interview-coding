package Algo;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeTwoSortedArray {

    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 7};
        int n1 = arr1.length;

        int[] arr2 = {2, 4, 6, 8};
        int n2 = arr2.length;
        int c[]=new int[n1+n2];
        int result[]=merge(arr1,arr2,n1,n2,c);
for(int i=0;i<result.length;i++){
    System.out.println(result[i]);
}
       // Stream.of(result).forEach(v->System.out.println(v));
    }

    public static int[] merge(int a[],int b[],int m,int n,int c[]){

        if(a==null && b==null)
            return null;
        if(a==null)
            return b;
        if(b==null)
            return a;

        int i=0;
        int j=0;
        int k=0;
        while(i<m&&j<n){
            if(a[i]<b[j]){
                c[k++]=a[i++];
               // i++;
            }else{
                c[k++]=b[j++];
                //j++;
            }
           // k++;
        }

        while (i<m){
            c[k++]=a[i++];

        }
        while (j<n){
            c[k++]=b[j++];

        }

        return c;
    }
}
