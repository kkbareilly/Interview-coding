package Algo;

public class WaterTappingStorage {

    public static void main(String[] args) {
        int a[]={1,8,6,2,5,4,8,3,7};
        //System.out.println(storage(a,a.length));
        System.out.println(waterStorage(a));

    }
   /* public static int storage(int a[], int n){

        int j=0;
        int hi=n-1;
        int left_max=0;
        int right_max=0;
        int result=0;
        while (j<=hi){
            if(a[j]<a[hi] ){
                if(a[j]>left_max){
                    left_max=a[j];
                }else {
                    result+=left_max-a[j];
                }
                j++;
            }else{
                if(a[hi]>right_max){
                    right_max=a[hi];
                }else {
                    result+=right_max-a[hi];
                }
                hi--;
            }
        }
        return result;
    }*/

    public static int waterStorage(int a[]){
        int max=0;
        int low=0;
        int high=a.length-1;
        while (low<high){
            int left=a[low];
            int right=a[high];
            int depth=high-low;
            int height=Math.min(left,right);
            max=Math.max(max,depth*height);
            if(low<high)
                low++;
            else
                high--;
        }
        return max;
    }
}
