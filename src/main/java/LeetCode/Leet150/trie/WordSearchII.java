package LeetCode.Leet150.trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

  Node root=new Node();

    public List<String> findWords(char[][] board, String[] words) {

        ArrayList<String> res=new ArrayList<>();
        Node node=buildTree(words);
         for(int i=0;i<board.length;i++){
             for (int j=0;j<board[0].length;j++){
                 dfs(board,i,j,node,res);
             }
         }
         return res;
    }

    public void dfs(char[][]board,int i,int j, Node p,List<String> res){
        char c=board[i][j];
        if(c=='#' || p.children[c-'a']==null) return;
        p=p.children[c-'a'];
        if(p.word!=null){
            res.add(p.word);
            p.word=null;
        }
        board[i][j]='#';
        if(i>0)
            dfs(board,i-1,j,p,res);
        if(j>0)
            dfs(board,i,j-1,p,res);
        if(i<board.length-1)
            dfs(board,i+1,j,p,res);
        if(j<board[0].length-1)
            dfs(board,i,j+1,p,res);
        board[i][j]=c;
    }
    private Node buildTree(String[] words){
        for(String word:words){
            Node curr=root;
            insert(word,curr);
        }
        return root;
    }
  public Node insert(String world,Node curr){

      for(int i=0;i<world.length();i++){
          int index=world.charAt(i)-'a';
          if(curr.children[index]==null){
             curr.children[index]=new Node();
          }
          curr=curr.children[index];
      }
      curr.word=world;
     return curr;
  }



    class Node{
        Node children[]=new Node[26];;
        String word;
    }
}
