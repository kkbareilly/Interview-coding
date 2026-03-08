package LeetCode.Leet150.arraystring;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HIndex {
public static void main(String[] args){
int m[]={3,0,6,1,5};
hIndex(m);
}
    public static int hIndex(int[] citations) {
    int i=0;
        citations= IntStream.of(citations).boxed().sorted(Comparator.reverseOrder()).mapToInt(m->m).toArray();
     for( i=1;i<citations.length-1;i++){
       if(citations[i-1]<i){
           break;
       }

   }
    System.out.println(i-1);
        return i-1;
    }
}
