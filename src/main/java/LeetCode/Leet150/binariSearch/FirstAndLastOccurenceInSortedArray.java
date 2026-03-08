package LeetCode.Leet150.binariSearch;

public class FirstAndLastOccurenceInSortedArray {

    public int[] searchRange(int[] nums, int target) {
      int left=leftIndex(nums,target);
        int right=rightIndex(nums,target);
        return new int[]{left,right};
    }

    private int leftIndex(int nums[],int target){
        int start=0;
        int end=nums.length-1;
        int index=-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                index=mid;
            }
            if(nums[mid]>=target){
                end=mid-1;
            }else{
                start=mid+1;
            }}
        return index;
    }

    private int rightIndex(int nums[],int target){
        int start=0;
        int end=nums.length-1;
        int index=-1;

        while(start<=end){
            int mid=start+(end-start)/2;
        if(nums[mid]==target){
            index=mid;
        }
        if(nums[mid]<=target){
            start=mid+1;
        }else{
            end=mid-1;
        }}
        return index;
    }

}
