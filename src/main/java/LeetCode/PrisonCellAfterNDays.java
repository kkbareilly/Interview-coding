package LeetCode;

import java.util.*;

public class PrisonCellAfterNDays {
    public static void main(String[] args) {
        int a[]={0,1,0,1,1,0,0,1};
       Arrays.stream( prisonCell(a,7)).forEach(data->{
           System.out.println(data);
       });
    }


public static int[] prisonCell(int []firstDay,int n){
    if(firstDay==null ||firstDay.length==0||n<=0)return firstDay;
    HashSet<String> list=new HashSet<>();
    int cycle=0;
    boolean isCycle=false;
    for(int i=0;i<n;i++){
        int []day=nextDay(firstDay);
       String prisonDay= Arrays.toString(day);
        if(!list.contains(prisonDay)){
            cycle++;
            list.add(prisonDay);
        }else {
            isCycle=true;
            break;
        }
        firstDay=day;
    }
   if(isCycle){
        n=n%cycle;
       for(int i=0;i<n;i++){
           firstDay=nextDay(firstDay);
       }
   }
   return firstDay;
}

public static int[] nextDay(int []a){
    int temp[]=new int[a.length];
    for(int i=1;i<a.length-1;i++){
        if(a[i-1]==a[i+1]){
            temp[i]=1;
        }
    }
    return temp;
}
}
