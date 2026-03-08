package LeetCode.Leet150.graph.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SnakandLadder {
public static void main(String[] args){
   int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
   SnakandLadder l=new SnakandLadder();
    System.out.println(l.snakesAndLadders(board));
    ;

}
    public int snakesAndLadders(int[][] board) {
      int n=board.length;
      int steps=0;
      boolean visited[][]=new boolean[n][n];
        Queue<Integer> q=new LinkedList();
        q.add(1);
        visited[n-1][0]=true;
        while (!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                int x=q.poll();
                if(n*n==x) return steps;
                for(int k=1;k<=6;k++){
                    if(k+x>n*n) break;
                    int pos[]=getCoordinate(k+x,n);
                    int r=pos[0];
                    int c=pos[1];
                    if(visited[r][c]==true) continue;
                    visited[r][c]=true;
                    if(board[r][c]==-1)
                        q.add(k+x);
                    else
                        q.add(board[r][c]);
                }

            }
            steps++;
        }
        return -1;
    }
   private int[] getCoordinate(int curr,int n) {
        int r=n-(curr-1)/n -1;
        int c=(curr-1)%n;
        if(r%2==n%2){
            return new int[]{r,n-1-c};
        }else{
            return new int[]{r,c};
        }
   }
}


