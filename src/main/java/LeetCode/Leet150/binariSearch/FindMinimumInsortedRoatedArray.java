package LeetCode.Leet150.binariSearch;

public class FindMinimumInsortedRoatedArray {

    public int find(int a[]){
        int start=0;
        int end=a.length-1;

        while (start<end){
            int mid=start+(end-start)/2;
            if(a[mid]>=a[end])
                start=mid+1;
            else
                end=mid;
        }
        return a[start];
    }


/*    public int getMini(int a[]){
        if(a.length==0) return -1;
        if(a.length==1) return a[0];
        int start=0;
        int end=a.length-1;
        while (start<end){
            int mid=start+(end-start)/2;
        }
    }*/
}
