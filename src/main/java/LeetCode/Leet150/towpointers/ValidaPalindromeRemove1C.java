package LeetCode.Leet150.towpointers;

public class ValidaPalindromeRemove1C {

    public  boolean palindrome(String s){
        if(s==null)
            return true;
        int start_p=0;
        int end_p=s.length()-1;
        while (start_p<=end_p){
            if (s.charAt(start_p)==s.charAt(end_p)){
                start_p++;
                end_p--;
            }else {
               return isValid(s,start_p+1,end_p)|| isValid(s,start_p,end_p--);
            }

        }
        return true;
    }

   public boolean isValid(String s,int left,int right){
        while (left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
   }

}
