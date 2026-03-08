package DynamicPrograming.LCS;

public class LongestRepeatingSubsequence {




    String s="abcdbsbeb";


    public int lRS(String s,String s1){

        int t[][]=new int[s.length()+1][s.length()+1];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(i==0 ||j==0){
                    t[i][j]=0;
                }
            }
        }


        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(i==0 ||j==0){
               if(s.charAt(i-1)==s1.charAt(j-1) && i!=j){
               t[i][j]=1+t[i-1][j-1];
               }else{
                   t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
               }
                }
            }
        }
        return t[s.length()][s.length()];
    }
}
