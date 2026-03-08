package DynamicPrograming.mcm;

public class MatrixChainMultiplicationMemorization {

    static int  d[][];
    public static void main(String[] args) {
        int b[]={40,20,30,10,30};
        int size=b.length;
         d=new int[b.length+1][b.length+1];
         for(int i=0;i<size;i++){

             for(int j=0;j<size;j++){
                d[i][j]=-1;
             }
         }
        System.out.println( solve(b,1,size-1));
    }
    public static int solve(int a[],int i,int j){

        if(i>=j)
            return 0;
        if(d[i][j]!=-1)
            return d[i][j];

        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){

            int temp=solve(a,i,k)+solve(a,k+1,j)+(a[i-1]*a[k]*a[j]);

            if(temp<min){
                min=temp;
            }
        }
        return d[j][j]=min;
       // return min;
    }
}
