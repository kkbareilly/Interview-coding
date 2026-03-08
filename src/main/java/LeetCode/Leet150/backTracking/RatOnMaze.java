package LeetCode.Leet150.backTracking;

public class RatOnMaze {

  int N=4;
    public boolean printMazePath(int[][] maze){
        int sol[][]=new int[maze.length][maze[0].length];
        if(! printMazePathUtil(maze,N,N,sol)){
            return false;
        }
      print(sol);
        return true;
    }

    public boolean printMazePathUtil(int[][]maze,int x,int y,int sol[][]){

        if(x==N-1 && y==N-1 && maze[x][y]==1){
            sol[x][y]=1;
            return true;
        }

        if(isSafe(maze,x,y)){
            sol[x][y]=1;
            if(printMazePathUtil(maze,x+1,y,sol)){
                return true;
            }
            if(printMazePathUtil(maze,x,y+1,sol)){
                return true;
            }

            sol[x][y]=0;
        }
        return false;
    }
    private boolean isSafe(int maze[][],int x,int y){
        if(x>0 && x<N && y>0 && y<N&& maze[x][y]==1)
            return true;
        else
            return false;
    }
private void print(int[][]sol){
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if(sol[i][j]==1)
        System.out.println(sol[i][j]);
        }}
}
}
