package DynamicPrograming.LCS;

public class MinimumNumberOfInsertionandDeletion {

    public static void main(String[] args){
        //convert s1->s2
        String s1="heap";
        String s2="pea";
        int numberOfDeletion=s1.length()-LCSBottomUp.lcs(s1,s2,s1.length(),s2.length());
        int numberOfInsertion=s2.length()-LCSBottomUp.lcs(s1,s2,s1.length(),s2.length());


    }
}
