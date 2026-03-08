package Sorting;

import java.util.Arrays;

public class Merge {


    public static void main(String[] args) {
        int a[]={20,1,45,3,67,4};
        merge(a);
        for(int s:a){
            System.out.println(s);
        }
        Arrays.asList(a).stream().forEach(al->System.out.println(al));
    }

    private static void merge(int a[]){
        if(a.length<=1)
            return;
        int mid=a.length/2;
        int k=0;
        int []left=new int[mid];
        int[]right=new int[a.length-mid];

        for(int i=0;i<=mid-1;i++){
            left[i]=a[i];
        }
        for(int j=mid+1;j<=a.length-1;j++){
            right[k]=a[j];
            k++;
        }
        merge(left);
        merge(right);
        mergeSort(left,right,a);

    }

    private static int[] mergeSort(int[]left,int[]right,int a[]){

        int li=left.length;
        int ri=right.length;
                int i=0,j=0,k=0;

                while(i<li && j<ri){
                    if(left[i]<=right[j]){
                        a[k]=left[i];
                        i++;
                    }else{
                        a[k]=right[j];
                        j++;
                    }
                    k++;
                }

                while (i<li){
                    a[k]=left[i];
                    i++;
                    k++;
                }
        while (j<ri){
            a[k]=right[j];
            j++;
            k++;
        }

        return a;
    }
}
