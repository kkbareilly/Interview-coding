package LeetCode.Leet150.dp;

import java.util.Arrays;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where s and t are divided into n and m
 * substrings
 *  respectively, such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
       if(s1.length()+s2.length()<s3.length())
           return false;
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        for(int []ip:dp){
            Arrays.fill(ip,-1);
        }
       return solve(0,0,s1,s2,s3,dp)==1;
    }

    public int solve(int i,int j,String s1,String s2,String s3,int[][]dp){

        if(i==s1.length() && j==s2.length()) return 1;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i<s1.length() && i+j<s3.length() && s1.charAt(i)==s3.charAt(i+j)&& solve(i+1,j,s1,s2,s3,dp)==1) return dp[i][j]=1;
        if(j<s2.length() && i+j<s3.length() && s2.charAt(j)==s3.charAt(i+j)&& solve(i,j+1,s1,s2,s3,dp)==1) return dp[i][j]=1;
        return dp[i][j]=0;
    }
}
