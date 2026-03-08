package LeetCode.Leet150.arraystring;

public class RemoveDuplicate {
    public static void main(String[] args){

    }

    public static int removeDuplicates(int[] nums) {

        int index=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1])
                nums[index++]=nums[i+1];
        }
        return index;
    }
}

// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
// The order of the elements may be changed. Then return the number of elements in nums which are
// not equal to val.
//
// Consider the number of elements in nums which are not equal to val be k, to get accepted, you
// need to do the following things:
//
// Change the array nums such that the first k elements of nums contain the elements which are not
// equal to val. The remaining elements of nums are not important as well as the size of nums.
// Return k.
