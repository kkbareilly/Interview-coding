package DynamicPrograming.mcm;

public class NumberOfPartionToConvertStringInPalindrom {


    public static void main(String[] args) {
        String s="onitinp";
        System.out.println(solve(s,0,s.length()-1));
    }
    public static int solve(String str,int i,int j){
        if(i>=j)
            return 0;
        if(isPalidrom(str,i,j)){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int tem=solve(str,i,k)+solve(str,k+1,j)+1;
              if(min>tem)
                  min=tem;
        }

        return min;
    }

    private static boolean isPalidrom(String str,int i,int j){
        while (i<j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
                continue;
            }else {
                return false;
            }
        }

        return true;
    }
}
