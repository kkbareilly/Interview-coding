package DynamicPrograming.bounded;

public class EqualSumPartion {

    public static void main(String[] args){
        int a[]={2,3,4,5,6};
        int sum=0;
        for(int dt:a){
            sum+=dt;
        }
        if(sum%2!=0){
      System.out.println("not possible");
        }else{
           System.out.println( subsetSum(a,sum/2));
        }
    }

    public static boolean subsetSum(int a[],int sum){
        boolean mat[][]=new boolean[a.length+1][sum+1];
        for(int i=0;i<sum+1;i++){
            mat[0][i]=false;
        }
        for(int i=0;i<a.length+1;i++){
            mat[i][0]=true;
        }

        for(int i=1;i<a.length+1;i++){
            for(int j=1;j<sum+1;j++){
                if(a[i-1]<=j){
                    mat[i][j]=mat[i-1][j-a[i-1]]||mat[i-1][j];
                }else
                    mat[i][j]=mat[i-1][j];
            }
        }
       return mat[a.length] [sum];
    }
}
