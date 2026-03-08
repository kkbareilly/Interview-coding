package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SnackAndLader {


    public int getSteps(int[][]mat){
        int n=mat.length;
        int steps=0;
        boolean[][]visited=new boolean[n][n];
        Queue<Integer> queue=new LinkedList();
        queue.add(mat[n-1][0]);
        visited[n-1][0]=true;

        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++) {
                int x = queue.poll();
               if(x==n*n)
                   return steps;
               for(int k=1;k<6;k++){
                   if(k+x>n*n)
                       break;;
                   int pos[]=findCoordinates(k+x,n);
                   int r=pos[0];
                   int c=pos[1];
                   if(visited[r][c]==true) continue;
                   visited[r][c]=true;
                   if(mat[r][c]==-1)
                       queue.add(k+x);
                   else
                       queue.add(mat[r][c]);
               }
            }
            steps++;
        }
         return -1;
    }
    public int []findCoordinates(int current,int n){
        int r=n-(current-1)/n-1;
        int c=(current-1)%n;
        if(r%n==c%n){
            return new int[]{r,n-c-1};
        }else{
            return new int[]{r,c};
        }
    }
}
