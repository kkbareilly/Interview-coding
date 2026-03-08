package LeetCode;

public class LongestValidParanthesis {



    public static void main(String[] args) {
        String s="";
        char [] a=s.toCharArray();
        int dp[]=new int[a.length+1];
        int i=0;
        int j=0;
        int res=0;
        for(i=0;i<a.length;i++){
            j=i-dp[i]-1;
            if(a[j]=='(' && j>=0&& a[i]==')'){
                dp[i+1]=dp[i]+dp[j]+2;
            }
          res=Math.max(res,dp[i+1]);
        }
    }

}
