package Sorting;

import java.util.Arrays;

public class Selection {

    public static void main(String[] args) {
        int a[]={20,1,45,3,67,4};
        select(a);
        Arrays.asList(a).stream().forEach(al->System.out.println(al));
    }
    private static int[] select(int []a){
        int minValue=0;
        int minIndex=0;
        for(int i=0;i<a.length;i++){

            minValue=a[i];
            minIndex=i;
            for(int j=i;j<a.length;j++){
                 if(a[j]<minValue){
                     minIndex=j;
                     minValue=a[j];
                 }
            }

            if(minValue<a[i]){
                int temp=a[i];
                a[i]=a[minIndex];
                a[minIndex]=temp;
            }
        }
        return a;
    }
}
