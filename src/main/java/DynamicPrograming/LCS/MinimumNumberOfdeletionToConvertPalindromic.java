package DynamicPrograming.LCS;

public class MinimumNumberOfdeletionToConvertPalindromic {
    public static void main(String[] args){
        String s="agbcbda";
      int minimumDelete=s.length()-  LCSBottomUp.lcs(s,new StringBuilder().append(s).reverse().toString(),s.length(),s.length());
   /*
    LPS= 1 / minimum delete;
    */

    }
}
