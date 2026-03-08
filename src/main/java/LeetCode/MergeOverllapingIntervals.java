package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MergeOverllapingIntervals {

    public Integer[][] overlap(Integer a[][]){

        List<Integer[]> output=new ArrayList<Integer[]>();
        Integer[] current_int=a[0];
        output.add(current_int);
        for(Integer[] interval:a){
            int current_begin=current_int[0];
            int current_end=current_int[1];
            int next_begin=interval[0];
            int next_end=interval[1];
            if(current_end>next_begin){
                current_int[1]=next_begin;
            }else {
                current_int=interval;
                output.add(current_int);
            }


        }
        return output.toArray(new Integer[output.size()][]);
    }
}
