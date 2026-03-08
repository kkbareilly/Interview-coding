package LeetCode;

public class PickElementOrLeader {
    public static void main(String[] args) {
        int a[]={1,2,1,3,4,5,4,7,6,3};
        System.out.println(leader(a));
    }

    public static int leader(int a[]){
        int left=0;
        int right=a.length;
        while (left<right){
            int mid=left+(right-left)/2;
            if(a[mid]<a[mid+1]){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }
}
