package LeetCode.Leet150.arraystring;

import java.util.ArrayList;
import java.util.List;

public class RemoveElementFromUnsortedArray {
public static void main(String[] args){
int a[]=new int[]{1,4,3,4,2,2,1,6,3,8,5,3};
    findDuplicate(a).stream().forEach(s -> System.out.println(s));
}
    public static List<Integer> findDuplicate(int[] nums) {
        ArrayList list=new ArrayList();
        int n = nums.length;
        boolean[] set = new boolean[n+1];
        for(int i=0;i<n;i++) {
            if(set[nums[i]]){
                continue;
          } else {
            set[nums[i]] = true;
            list.add(nums[i]);
            }
        }
        return list;
    }
}
