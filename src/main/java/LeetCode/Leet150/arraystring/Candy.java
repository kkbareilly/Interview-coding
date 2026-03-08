package LeetCode.Leet150.arraystring;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {

        int res[]=new int[ratings.length];
         Arrays.fill(res,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                res[i]=res[i-1]+1;
            }
        }

        for(int i=ratings.length-1;i>0;i--){
            if(ratings[i]<ratings[i-1] && res[i]>=res[i-1]){
                res[i-1]=res[i]+1;
            }
        }

        return Arrays.stream(res).sum();
    }
}
