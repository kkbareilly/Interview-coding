package LeetCode.Leet150.graph.leetcode;

public class SurroundedRegion {
public static void main(String[] args){
    char[][]mat={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
new SurroundedRegion().surrounded(mat);
for(int i=0;i<mat.length;i++){
    for(int j=0;j<mat[0].length;j++){
        System.out.println(mat[i][j]);
    }
}
}
    public void surrounded(char mat[][]){
        if(mat.length==0 || mat[0].length==0)
            return;
        int row=mat.length;
        int col=mat[0].length;
        for(int i=0;i<row;i++){
            if(mat[i][0]=='O'){
                dfs(mat,i,0);
            }
            if(mat[i][col-1]=='O'){
                dfs(mat,i,col-1);

            }
        }
        for(int i=0;i<col;i++){
            if(mat[0][i]=='O'){
                dfs(mat,0,i);

            }
            if(mat[row-1][i]=='O'){
                dfs(mat,row-1,i);

            }
        }
        for(int i=0;i<row;i++){
      for (int j = 0; j < col ; j++) {
        if (mat[i][j] == 'O') {
          mat[i][j]='X';
        }
        else if (mat[i][j] == '*') {
            mat[i][j]='O';
        }
            }
        }
    }

    public void dfs(char mat[][],int i,int j){

        if(i<0|| i>mat.length ||j<0||j>mat[0].length){
            return;
        }
        if(mat[i][j]=='O')
            mat[i][j]='*';
        if(i>0&&mat[i-1][j]=='O')
            dfs(mat,i-1,j);
        if(i<mat.length-1&&mat[i+1][j]=='O')
            dfs(mat,i+1,j);
        if(j>0&&mat[i][j-1]=='O')
            dfs(mat,i,j-1);
        if(j<mat[0].length-1&&mat[i][j+1]=='O')
            dfs(mat,i,j+1);

    }




    public void solve(char[][] board) {

        if(board.length==0)
            return;
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                dfs(i,0,board);
            }

            if(board[i][board[0].length-1]=='O'){
                dfs(i,board[0].length-1,board);
            }
        }
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                dfs(0,i,board);
            }

            if(board[board.length-1][i]=='O'){
                dfs(board.length-1,i,board);
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X' ;
                }else if(board[i][j]=='*'){
                    board[i][j]='O';
                }
            }
        }
    }

    private void dfs(int i, int j,char[][]board){

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='O'){
            return;
        }


        board[i][j]='*';
        dfs(i-1,j,board);
        dfs(i+1,j,board);
        dfs(i,j-1,board);
        dfs(i,j+1,board);
    }
}
