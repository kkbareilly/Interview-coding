package DynamicPrograming.mcm;

public class EggDropping {

    public static void main(String[] args) {
        System.out.println(solve(2,4));
    }

    public static int solve(int e,int f){
        if(f==1 || f==0)
            return f;
        if(e==1)
            return f;
        int k;
        int min=Integer.MAX_VALUE;
        for( k=1;k<=f;k++){
            int tem=1+Math.max(solve(e-1,k-1),solve(e,f-k));
            if(tem<min)
                min=tem;
        }
        return min;
    }
}
