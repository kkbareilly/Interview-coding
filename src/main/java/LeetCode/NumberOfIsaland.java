package LeetCode;

public class NumberOfIsaland {

    public static void main(String[] args) throws java.lang.Exception
    {
        int M[][] = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        NumberOfIsaland I = new NumberOfIsaland();
        System.out.println("Number of islands is: " + I.solve(M));
    }

    public int solve(int a[][]){

        if(a==null || a.length==0)
            return 0;
        int numberofIsaland=0;

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(a[i][j]==1){
                    numberofIsaland+=dfs(a,i,j);
                }
            }
        }
        return numberofIsaland;
    }

    public int dfs(int a[][],int i,int j){
        if(i<0 || i>=a.length || j<0 || j>=a[i].length || a[i][j]==0)
            return 0;

        a[i][j]=0;
        dfs(a,i+1,j);
        dfs(a,i-1,j);
        dfs(a,i,j+1);
        dfs(a,i,j-1);
    /*    dfs(a,i-1,j-1);
        dfs(a,i+1,j+1);
        dfs(a,i-1,j+1);
        dfs(a,i+1,j-1);*/

      return 1;
    }
}
