package DynamicPrograming.LCS;

import java.util.Arrays;

public class MemorizationLCS {

    String s1="abcd";
    String s2="abcd";
    int n=s1.length();
    int m=s2.length();
    int dp[][]=new int [n+1][m+1];
    public static void main(String[] args) {

        MemorizationLCS ms=new MemorizationLCS();

        for(int i=0;i<ms.n+1;i++){
            for (int j=0;j<ms.m+1;j++){
                ms.dp[i][j]=-1;
            }
        }
        System.out.println(ms.mLcs(ms.s1,ms.s2,ms.n,ms.m)); ;
    }
    public  int mLcs(String s1,String s2,int n,int m){

        if(n==0 ||m==0)
            return 0;

            if(n<s1.length() &&dp[n][m]!=-1)
                return dp[n][m];
            if(s1.charAt(n-1)==s2.charAt(m-1))
                return dp[n][m]=1+mLcs(s1,s2,n-1,m-1);
            else
                return dp[n][m]=Math.max(mLcs(s1,s2,n,m-1),mLcs(s1,s2,n-1,m));
    }
}
