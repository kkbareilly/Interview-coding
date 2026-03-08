package DynamicPrograming.LCS;

public class NumberOfInsertionTomakeStringPalindromic {
    //# of insertion= # deletion
    //because to make a string palindromic what ever character need to be deleted same character can be inserted to make it in pair

    public static void main(String[] args){
        String s="absddww";
      int numberOfinsertion=s.length()-  LCSBottomUp.lcs(s,new StringBuilder(s).reverse().toString(),s.length(),s.length());
    }
}
