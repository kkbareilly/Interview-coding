package LeetCode.Arrays;

public class RemoveDuplicatesFromsortedArrayInplace {
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
        int index=1;
        for (int i=0;i<a.length-1;i++){
            if(a[i]!=a[i+1]){
                a[index++]=a[i+1];
            }
        }
        return index;
    }
}
