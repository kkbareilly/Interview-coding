package LeetCode.Leet150.arraystring;

public class RemoveDuplicatekeep2consequtive {

    public static void main(String[] args){
      //  remove()
    }
    public static int remove(int a[]){

        int l=0;
        int r=0;
        int count=1;
       while (r<a.length){
            while (r+1<a.length && a[r]==a[r+1]){
                count++;
                r++;
            }
            for (int i=0;i<Math.min(2,count);i++){
                a[l]=a[r];
                l++;
            }
            r++;
        }
       return l;
    }

    public int removeDup(int a[]){
        int i=0;
        for (int n: a){
            if(i<2 || n!=a[i-2]){
                a[i++]=n;
            }
        }
        return i;
    }
}

// Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such
// that each unique element appears at most twice. The relative order of the elements should be kept
// the same.
//
// Since it is impossible to change the length of the array in some languages, you must instead have
// the result be placed in the first part of the array nums. More formally, if there are k elements
// after removing the duplicates, then the first k elements of nums should hold the final result. It
// does not matter what you leave beyond the first k elements.
//
// Return k after placing the final result in the first k slots of nums.
//
// Do not allocate extra space for another array. You must do this by modifying the input array
// in-place with O(1) extra memory.
