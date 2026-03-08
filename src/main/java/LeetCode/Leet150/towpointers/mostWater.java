package LeetCode.Leet150.towpointers;

public class mostWater {
    public int maxArea(int[] height) {
        int start=0;
        int end=height.length-1;
        int max_area=0;
        while (start<end){
            if(height[start]<height[end]){
                max_area=Math.max(max_area,height[start]*(end-start));
                start++;
            }else{
                max_area=Math.max(max_area,height[end]*(end-start));
                end--;
            }
        }
        return max_area;
    }
}
