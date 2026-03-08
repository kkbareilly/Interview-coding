package LeetCode.Leet150.maths;

import java.util.HashMap;
import java.util.Map;

public class MaximumPointOnLine {

    public int maxPoints(int[][] points) {
         if(points.length<2)
             return points.length;

         int result=1;
         int row=points.length;
         int slop=Integer.MAX_VALUE;

         for(int i=0;i<row;i++){
             Map<Integer,Integer>map=new HashMap<>();

             for(int j=i+1;j<row;j++){
                 if(points[j][0]==points[i][0]){
                     slop=Integer.MAX_VALUE;
                 }else{
                     slop=(points[j][1]-points[i][1])/(points[j][0]-points[i][0]);
                 }
                Integer value= map.getOrDefault(slop,0);
                 map.put(slop,value+1);
                 result=Math.max(result,map.get(slop));

             }
         }
         return result;
    }
}
