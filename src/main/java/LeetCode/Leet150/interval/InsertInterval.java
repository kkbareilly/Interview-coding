package LeetCode.Leet150.interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

public static void main(String[] args){

}

    public static int[][]insert(int[][]interval,int[]newInterval){
        List<int[]> result=new ArrayList<>();
        for(int[] in:interval){
            if(in[1]<newInterval[0]){
                result.add(in);
            }else if(newInterval[1]<in[0]){
             result.add(newInterval);
             newInterval=in;
            }else {
                newInterval[0]=Math.min(in[0],newInterval[0]);
                newInterval[1]=Math.max(in[1],newInterval[1]);

            }

        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
