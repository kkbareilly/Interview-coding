package DynamicPrograming.LCS;

public class PrintLCS {
    public static void main(String[] args){
        String s1="abc";
        String s2="abcd";

       LCSBottomUp.lcs(s1,s2,s1.length(),s2.length());
    }

    public void print(String s1,String s2,int[][]t){
        int r=t.length;
        int c=t[0].length;
        int i=s1.length();
        int j=s2.length();
        StringBuilder result=new StringBuilder();

        while (i>0 && j>0){
            if(s1.charAt(i)==s2.charAt(j)){
                result.append(s1.charAt(i-1));
                i--;j--;
            }else if(t[i][j-1]>t[i-1][j]){
                  j--;
            }else{
                i--;
            }
        }
    System.out.println(result.toString());
    }
}
