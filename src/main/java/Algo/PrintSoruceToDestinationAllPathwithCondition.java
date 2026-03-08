package Algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintSoruceToDestinationAllPathwithCondition {

    public static void printPath(int[][]a, Stack path, int x, int y){

        int m=a.length;
        int n=a[0].length;

        if(x==m-1&& y==n-1){
            path.add(a[x][y]);

            //  System.out.println(path);

            for (Object d:path.toArray())
               System.out.print(d);
            System.out.println();
            path.pop();
            return;

        }
        path.add(a[x][y]);
        //right
        if(x>=0 && x<m && y+1>=0&&y+1<n)
            printPath(a,path,x,y+1);
        //down
        if(x+1>=0 && x+1<m && y>=0&&y<n)
            printPath(a,path,x+1,y);

        path.pop();
    }


    public static void printPathAll(int[][]a, Stack path, int x, int y){

        int m=a.length;
        int n=a[0].length;

        if(x==m-1&& y==n-1){
            path.add(a[x][y]);

            //  System.out.println(path);

            for (Object d:path.toArray())
                System.out.print(d);
            System.out.println();
            path.pop();
            return;

        }
        path.add(a[x][y]);
        //right
        if(x>=0 && x<m && y+1>=0&&y+1<n)
            printPathAll(a,path,x,y+1);
        //down
        if(x+1>=0 && x+1<m && y>=0&&y<n)
            printPathAll(a,path,x+1,y);
        if(x>=0 && x<m && y-1>=0&&y-1<n)
            printPathAll(a,path,x,y-1);
        //down
        if(x-1>=0 && x-1<m && y>=0&&y<n)
            printPathAll(a,path,x-1,y);

        path.pop();
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

      //
          printPath(mat, path, x, y);
        //printPathAll(mat, path, x, y);
    }
}
