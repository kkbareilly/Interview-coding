package matrix;

import java.util.Stack;

public class FindAllThePathSoruceToDestinationInMatrix {


    public static void findPath(int mat[][], Stack<Integer> path, int x, int y){
        int m=mat.length;
        int n=mat[0].length;
        if(x==m-1 && y==n-1)
        {
            path.add(mat[x][y]);
            System.out.println(path);
            path.pop();
        }
        path.add(mat[x][y]);
        //move right
        if(x>=0 && x<m && y+1>=0 && y+1<n){
            findPath(mat,path,x,y+1);
        }
        //move down
        if(x+1>=0 && x+1<m && y>=0 && y<n){
            findPath(mat,path,x+1,y);
        }
        // backtrack: remove the current cell from the path
        path .pop();
    }

    public static void main(String[] args) {
        int[][] mat =
                {
                        { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 }
                };

        Stack<Integer> path = new Stack<>();

        // start from `(0, 0)` cell
        int x = 0, y = 0;

        findPath(mat, path, x, y);
    }
}
