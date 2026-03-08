package LeetCode.Leet150.arraystring;
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
public class MajorityElement {

    public static void main(String[] args){
        int a[]={3,5,1,1,1,1,5,5,5,2,5,5,4,5};
       // int b[]={3,2,3};
    System.out.println(major(a));
    }
    public static int major(int a[]){

        int res=0;
        int count=0;


        for(int i=0;i<=a.length-1;i++){

            if(count==0)
                res=a[i];

          else if(a[i]==res){
                count=+1;
            }else{
                count=-1;
            }
        }

        return res;
    }
}
