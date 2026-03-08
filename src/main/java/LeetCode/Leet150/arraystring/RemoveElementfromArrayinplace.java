package LeetCode.Leet150.arraystring;

public class RemoveElementfromArrayinplace {

    public static void main(String[] args){
    System.out.println(remove(new int[]{0,1,2,2,4,0,3,2},2));
    }
    public static int remove(int a[], int val){
        int k=0;
        for(int i=0;i<a.length-1;i++){
            if(a[i]!=val){
                a[k]=a[i];
                k++;
            }
        }
        return k;
    }
}
