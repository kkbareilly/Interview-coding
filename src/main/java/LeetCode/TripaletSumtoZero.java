package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripaletSumtoZero {

    public static void main(String[] args) {
        List ls=new ArrayList();
        int a[]={-1,0,1,2,-1,-4};
        Arrays.sort(a);
        for(int i=0;i<a.length-2;i++){
            int j=i+1;
            int k=a.length-1;
            while (j<k) {
                int sum = a[j] + a[k];
                if (sum == -a[i]) {
                    ls.add(Arrays.asList(a[i], a[j], a[k]));
                    j++;
                    k--;
                }
                if (sum > -a[i])
                    k--;
                if (sum < -a[i])
                    j++;
            }
        }
        System.out.println(ls);
    }
}
