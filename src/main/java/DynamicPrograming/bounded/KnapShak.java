package DynamicPrograming.bounded;

public class KnapShak {
    int w=10;
    int wt[]={};
    int mat[][]=new int[wt.length+1][w+1];
    public int knapShake(int []wt,int val[],int w,int n){
        if(w==0||n==0)
            return 0;
        if(wt[n-1]<w){
            return Math.max(knapShake(wt,val,w-wt[n-1],n-1),knapShake(wt,val,w,n-1));
        }else
           return knapShake(wt,val,w,n-1);
    }

    public int knapShakeMemo(int []wt,int val[],int w,int n){
        if(w==0||n==0)
            return 0;
        if(mat[n][w]!=-1)
            return mat[n][w];
        if(wt[n-1]<w){
            return mat[n][w]=Math.max(knapShake(wt,val,w-wt[n-1],n-1),knapShake(wt,val,w,n-1));
        }else
            return mat[n][w]=knapShake(wt,val,w,n-1);
    }

    public int bottomUp(int []wt,int val[],int w,int n){
       for(int i=1;i<n;i++){
           for(int j=1;j<w;j++){
               if(wt[i-1]<j){
                   mat[i][j]=Math.max(val[i-1]+mat[i-1][j-wt[i-1]],mat[i-1][j]);
               }else
                   mat[i][j]=mat[i-1][j];
           }
       }
       return mat[n][w];
    }


    public boolean subsetSum(int [] a,int sum){
        int row=a.length+1;
        int col=sum+1;
        boolean mat[][]=new boolean[row][col];
        for(int i=0;i<sum+1;i++){
            mat[0][i]=false;
        }
        for(int i=0;i<a.length+1;i++){
            mat[i][0]=true;
        }
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(a[i-1]<j){
                    mat[i][j]=mat[i-1][j-a[i-1]]||mat[i-1][j];
                }else return mat[i-1][j];
            }
        }
        return mat[row-1][col-1];
    }
}
