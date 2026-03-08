package LeetCode.Leet150.binariSearch;

public class SearchInsertPosition {
public static void main(String[] args){
    int[] arr = { 1, 3, 5, 8 };
    int n = arr.length;
    int K = 4;

    System.out.println(findPosition(arr, K));
}
    public static int findPosition(int a[],int target){

        int low=0;
        int high=a.length-1;
        int mid=0;
        while (low<=high){
            mid=low+(high-low)/2;

            if(a[mid]==target)
                return mid;
            else if(target<a[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
}
