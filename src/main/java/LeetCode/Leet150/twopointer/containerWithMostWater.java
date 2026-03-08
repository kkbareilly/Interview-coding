package LeetCode.Leet150.twopointer;

public class containerWithMostWater {

    public int mostWater(int[] height){

        int startp=0;
        int endp=height.length-1;
        int maxArea=0;
        while (startp<endp){
            if(height[startp]<height[endp]){
                maxArea=Math.max(maxArea,height[startp]*(endp-startp));
                startp++;
            }else {
                maxArea=Math.max(maxArea,height[endp]*(endp-startp));
                endp--;
            }
        }
        return maxArea;
    }
}
