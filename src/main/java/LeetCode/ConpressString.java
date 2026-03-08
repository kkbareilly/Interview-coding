package LeetCode;

public class ConpressString {


    public static int conpress(char[]a){

        int i=0;
        int index=0;
        for (int j=0;j<a.length;){
            if(a[i]==a[j]){
                j++;
            }else{
               i=j;
               index=j-1;
            }
        }
        return 0;
    }
}
