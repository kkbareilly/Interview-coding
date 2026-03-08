package LeetCode.Arrays;

public class RemoveDuplicatesFromsortedArray11 {
  public static void main(String[] args) {
    //
      int a[]={0,0,0,1,1,2,2,4,4,4,4,6,7,7};
    System.out.println(remove(a));
      /*for(int i=0;i<remove(a);i++){
      System.out.println(a[i]);
      }*/
      for (int i=0;i<6;i++){
      System.out.println(a[i]);
      }
  }

    public static int remove(int a[]){
       if(a.length==0) return 0;
       int r=0;
       int l=0;
       while (r<a.length){
           int count=1;
           while (r+1<a.length&& a[r]==a[r+1]){
               count++;
               r++;
           }
           for(int p=0;p<Math.min(2,count);p++){
               a[l]=a[r];
               l++;
           }
           r++;

       }
        return r;
    }
}
