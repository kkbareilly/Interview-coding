package DynamicPrograming.LCS;

public class LongestPelindromicSubsequnce {
    public static void main(String[] args){
        String s="agbcba";
        int len=s.length()-1;
        String s1="";
        while (len>0){
            s1+=s.charAt(len);
            len--;
        }
      int LPS=  LCSBottomUp.lcs(s,s1,s.length(),s1.length());
    }
}
