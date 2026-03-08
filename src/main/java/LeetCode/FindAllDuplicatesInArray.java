package LeetCode;

import java.util.ArrayList;

public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int a[]={};
        ArrayList list=new ArrayList();
        for(int i=0;i<a.length;i++){
            int index=Math.abs(a[i])-1;
            if(a[index]<0)
                list.add(Math.abs(a[i]));
            a[index]=-a[index];
        }
    }

}
