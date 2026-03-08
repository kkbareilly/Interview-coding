package DynamicPrograming.bounded;

public class CountSubsetSum {
public static void main(String[] args){
    int a[]={2,3,4,5,6,8};
    System.out.println(countSubset(a,10));
}

    public static int countSubset(int a[],int sum){

        int mat[][]=new int[a.length+1][sum+1];

        for(int i=0;i<sum+1;i++){
            mat[0][i]=0;
        }
        for(int i=0;i<a.length+1;i++){
            mat[i][0]=1;
        }
        for(int i=1;i<a.length+1;i++){
            for(int j=1;j<sum+1;j++){
                if(a[i-1]<=j){
                    mat[i][j]=mat[i-1][j-a[i-1]]+mat[i-1][j];
                }else{
                    mat[i][j]=mat[i-1][j];
                }
            }
        }
        return mat[a.length][sum];
    }
}
