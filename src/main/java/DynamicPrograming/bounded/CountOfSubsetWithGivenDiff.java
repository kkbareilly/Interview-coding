package DynamicPrograming.bounded;

public class CountOfSubsetWithGivenDiff {
    public static void main(String[] args){
        int a[]={1,1,2,3};
        int diff=1;
        int sum=0;
        for(int d:a){
            sum+=d;
        }
    System.out.println(count(a,(sum
    +diff)/2));
    }

    public static int count(int a[],int sum){
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
