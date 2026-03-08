package DynamicPrograming.mcm;

public class ScrambledString {

    public static void main(String[] args) {
        String a="great";
        String b="rgeat";
        if(a.length()==b.length()){
            System.out.println(solve(a,b));
        }

    }


    public static boolean solve(String a,String b){

        int n=a.length();
        if(a.equals(b))
            return true;
        if(a.length()<=1)
            return false;
        if (n == 0) {
            return true;
        }

        boolean isScrambled=false;
        boolean iswapped=false;
        boolean isNotSwapped=false;

        for(int i=1;i<n;i++){

                  iswapped = (solve(new String(a.getBytes(),0,i), new String(b.getBytes(),n-i,i))
                         && solve(new String(a.getBytes(),i,n-i), new String(b.getBytes(),0,n-i)));
                  isNotSwapped = solve(new String(a.getBytes(),0,i), new String(b.getBytes(),0,i))
                         && solve(new String(a.getBytes(),i,n-i), new String(b.getBytes(),i,n-i));

        if(iswapped || isNotSwapped){
               isScrambled= true;

            }
        }
        return isScrambled;
    }
}
