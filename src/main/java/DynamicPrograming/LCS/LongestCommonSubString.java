package DynamicPrograming.LCS;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1="abdc";
        String s2="abxc";
        System.out.println(longestCommonSubString(s1,s2,s1.length(),s2.length()));
    }

    public  static int longestCommonSubString(String s1,String s2,int m,int n){
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<m+1;i++ ){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }
int result=0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }

            }
        }
       return result;
    }
}
