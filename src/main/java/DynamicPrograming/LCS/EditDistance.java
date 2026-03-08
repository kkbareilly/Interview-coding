package DynamicPrograming.LCS;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args){
        String s="horse";
        String s1="ros";
        int len=lcs(s,s1,s.length(),s1.length());
        System.out.println(len);
    }
    public  static int lcs(String s1,String s2,int m,int n) {
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<m+1;i++ ){
            for(int j=0;j<n+1;j++){
                    dp[0][j]=j;
            }
        }

        for(int i=0;i<m+1;i++ ){
            for(int j=0;j<n+1;j++){
                    dp[i][0]=i;
            }
        }


        for(int i=1;i<m+1;i++ ){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1)== s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
    }



    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n][m];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return distance(word1,word2,n-1,m-1,dp);
    }
    public int distance(String word1, String word2,int i,int j,int[][] dp)
    {
        if(i<0 && j<0)
        {
            return 0;
        }
        if(i<0 && j>=0)
        {
            return j+1;
        }
        if(i>=0 && j<0)
        {
            return i+1;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j))
        {
            int b=distance(word1,word2,i-1,j-1,dp);
            return dp[i][j]=b;
        }
        else
        {
            int x=distance(word1,word2,i-1,j,dp);
            int y=distance(word1,word2,i,j-1,dp);
            int z=distance(word1,word2,i-1,j-1,dp);
            int a=Math.min(x,y);
            return dp[i][j]=Math.min(a,z)+1;
        }
    }
}
