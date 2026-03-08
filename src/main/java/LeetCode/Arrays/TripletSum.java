package LeetCode.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripletSum {
  public static void main(String[] args) {
    //
      int a[]={-1,0,1,2,-1,-4};
   tripplet(a).stream().map(s->s).forEach(p->System.out.println(p));
  }

    public static Set<List> tripplet(int a[]){
        if(a.length<=0) return new HashSet();
        Set set=new HashSet();
        int j=0;
        int k=0;
        int sum=0;
        Arrays.sort(a);
        for(int i=0;i<a.length-2;i++){
            j=i+1;
            k=a.length-1;
      while (j < k) {
        sum = a[j] + a[k];
        if (sum == -a[i]) {
          set.add(Arrays.asList(a[i], a[j++], a[k--]));
        }
        if (sum < -a[i]) {
          j++;
        } else if (sum > -a[i]) {
          k--;
        }
            }
        }
        return set;
    }
}
