package LeetCode.String;

public class WildcardMatching {
  /*  Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

            '?' Matches any single character.
            '*' Matches any sequence of characters (including the empty sequence).
    The matching should cover the entire input string (not partial).*/
static Boolean dp[][];
    public boolean isMatch(String s, String p)
    {
        if(s==null || p==null)
            return s.equals(p);

        int m= s.length();
        int n= p.length();

        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;

        for(int i=0; i< n ;i++)
        {
            if(p.charAt(i) == '*')
                dp[0][i+1] = dp[0][i];
        }

        for(int i=1; i<m+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1];

                else if(p.charAt(j-1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }

        return dp[m][n];

    }

  public static void main(String[] args) {
    //
      String s="aaaaaa";
      String p="a*b";
      dp =new Boolean[s.length()+1][p.length()+1];
  }

    public boolean match(int i,int j,String s,String p){
        if(j==p.length()) return i==s.length();
        if(dp[i][j]!=null) return dp[i][j];
        boolean firstMatch= i<s.length() &&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.');
       boolean ans=false;
        if(j+1<p.length() &&p.charAt(j+1)=='*'){
            //aaaaaaaa
            //a*b
            ans= (firstMatch)&&match(i,j+1,s,p)||match(i,j+2,s,p);
        }else {
            //s=aa
            //p=ab
            ans= firstMatch&&match(i+1,j+1,s,p);
        }
        dp[i][j]=ans;
        return ans;
    }
}
