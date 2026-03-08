package LeetCode.Arrays;

import java.util.Arrays;

public class Segreagate01and2 {
    public static void main(String[] args){
   int []a={0,2,1,2,0};
        int []b={1,1,1,0,0};

        Arrays.stream(segregate(a)).forEach(s -> System.out.println(s));
    System.out.println("---------");
        Arrays.stream(segregate01(b)).forEach(s -> System.out.println(s));

    }

    public static int[] segregate(int a[]){
        if(a.length==0)
            return new int []{};
        int low=0;
        int mid=0;
        int high=a.length-1;
        while(mid<high){
            if(a[mid]==0){
                int temp=a[low];
                a[low]=a[mid];
                a[mid]=temp;
                low++;
                mid++;
            }else if(a[mid]==2){
                int temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                mid++;
                high--;
            }else mid++;
        }
        return a;
    }


    public static int[] segregate01(int a[]){
        if(a.length==0)
            return new int []{};
        int low=0;
        int high=a.length-1;
        while(low<=high){
            if(a[low]==1 || a[high]==0){
                int temp=a[low];
                a[low]=a[high];
                a[high]=temp;
                low++;
                high--;
            }
            else if(a[low]==0)
                low++;
            else if(a[high]==1)
                high--;
        }
        return a;
    }
}
