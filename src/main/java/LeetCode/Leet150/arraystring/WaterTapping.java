package LeetCode.Leet150.arraystring;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 Example 2:

 Input: height = [4,2,0,3,2,5]
 Output: 9
 */
public class WaterTapping {
public static void main(String[] args){
    int heights[]={3,1,2,5,3};
    System.out.println(trap(heights));
}
    public static int trap(int[] height) {

        int l=0;
        int r=height.length-1;
        int leftMax=height[l];
        int rightMax=height[r];
        int res=0;
        while (l<r){
             if(leftMax<rightMax){
                 l++;
                 leftMax=Math.max(leftMax,height[l]);
                 res+=leftMax-height[l];


             }else {
                 r--;
                 rightMax=Math.max(rightMax,height[r]);
                 res+=rightMax-height[r];
             }

        }
        return res;
    }

}
