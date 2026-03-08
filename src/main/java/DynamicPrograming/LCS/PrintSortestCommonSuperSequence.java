package DynamicPrograming.LCS;

public class PrintSortestCommonSuperSequence {

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
                result.append(s1.charAt(j-1));
                j--;
            }else{
                result.append(s2.charAt(i-1));
                i--;
            }
        }
        while (i>0){
            result.append(s1.charAt(i-1));
        }
        while (j>0){
            result.append(s2.charAt(j-1));
        }
        System.out.println(result.toString());
    }
}
