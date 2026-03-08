package LeetCode.Leet150.interval;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumArraowTobursstballons {

    public static void main(String[] args){

    }

    public static int minArray(int [][]points){
        if(points.length==0)
            return 0;
        Arrays.sort(points,Comparator.comparing(i->i[1]));
        int arrow=1;
        int end = points[0][1];
        for(int i=1;i<points.length;i++){
           if(points[i][0]>end){
               arrow++;
               end=points[i][1];
           }
        }
        return arrow;
    }

    public int totalArrow(int[][]points){
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int arrow=1;
        int end=points[0][1];
        for(int i=01;i<points.length;i++){
            if(points[i][0]>end){
                arrow++;
                end=points[i][1];
            }
        }
         return arrow;
    }
}
