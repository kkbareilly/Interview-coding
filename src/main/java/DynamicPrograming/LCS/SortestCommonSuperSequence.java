package DynamicPrograming.LCS;

import javax.swing.*;

public class SortestCommonSuperSequence {
    public static void main(String[] args){
        String s1="abcsde";
        String s2="abcrds";
        int scsq=s1.length()+s2.length()-lcs(s1,s2,s1.length(),s2.length());
    }

    public static int lcs(String s1,String s2,int m,int n){

        int[][]mat=new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(i==0 || j==0){
                    mat[i][j]=0;
                }
            }
        }


        for(int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    mat[i][j]=1+mat[i-1][j-1];
                    i--;j--;
                }else{
                    mat[i][j]=Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        return mat[m][n];
    }
}
