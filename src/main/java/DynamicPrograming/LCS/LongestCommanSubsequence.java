package DynamicPrograming.LCS;

public class LongestCommanSubsequence {

    static int result[][]=null;
public static void main(String[] args){
    String s="horse";
    String s1="ros";
   result=new int[s.length()+1][s1.length()+1];

    int len=s.length()+s1.length()-2*lcs(s,s1,s.length(),s1.length());
    System.out.println(len);
}
    public static int lcs(String s ,String s1,int m,int n){
        if(m==0 || n==0)
            return 0;
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                  result[i][j]=0;
                }
            }
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==s1.charAt(j-1)){
                    result[i][j]=1+result[i-1][j-1];
                }else {
                    result[i][j]=Math.max(result[i-1][j],result[i][j-1]);
                }
            }
        }

        return result[m][n];
    }

    public static String printLCS(String s1,String s2,int m,int n){

    int i=m;
    int j=n;
    StringBuilder sb=new StringBuilder();
    while (i>0 && j>0){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            sb.append(s1.charAt(i-1));
            i--;
            j--;
        }else{
          if(result[i-1][j]>result[i][j-1]){
              i--;
          }else{
             j--;
          }
        }
    }
      return  sb.toString();

    }
}
