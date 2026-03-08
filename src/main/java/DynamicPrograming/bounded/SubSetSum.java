package DynamicPrograming.bounded;

public class SubSetSum {
    public static void main(String[] args) {
        int a[]={2,3,7,8,10};
        int sum=11;

        System.out.println(sum(a,sum));
    }

    private static boolean sum(int a[],int sum){

        boolean t[][]=new boolean[a.length+1][sum+1];
        for(int i=0;i<sum+1;i++){
            t[0][i]=false;
        }
        for(int i=0;i<a.length+1;i++){
            t[i][0]=true;
        }
        for(int i=0;i<sum+1;i++){
           // for(int j=0;j<sum+1;j++) {
                System.out.print(t[0][i]);
            }//}

        for(int i=1;i<a.length+1;i++){
            for(int j=1;j<sum+1;j++){
               if(a[i-1]<=j){
                   t[i][j]=(t[i-1][j]||t[i-1][j-a[i-1]]);
               }else
                   t[i][j]=t[i-1][j];
            }
        }
//        for(int i=1;i<a.length+1;i++){
//            for(int j=1;j<sum+1;j++) {
//                System.out.print(t[i][j]);
//            }}
        return t[a.length][sum];
    }
}
