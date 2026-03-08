package DynamicPrograming.LCS;

public class LogestCommonSuperSequence {

    public int superSequence(String s1,String s2){
       int lcs= LCSBottomUp.lcs(s1,s2,s1.length(),s2.length());

        return s1.length()+s2.length()-lcs;
    }
}
