package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindFirstKMissionNumber {


    public int solve(int a[],int k){
            int i=0;
        while (i<a.length){
            if(a[i]>0 && a[i]<a.length && a[i]!=a[a[i]-1]){
                int otherIndex=a[i]-1;
                int temp=a[i];
                a[i]=a[otherIndex];
                a[otherIndex]=temp;
            }else {
                i++;
            }
        }
        List<Integer> missing=new ArrayList<>();
        Set<Integer> otherNumber=new HashSet<>();
        for(int j=0;j<a.length&& missing.size()<k;j++){
            if(a[i]!=i+1){
                missing.add(i+1);
                otherNumber.add(a[i]);
            }
        }
        return 0;
    }
}
