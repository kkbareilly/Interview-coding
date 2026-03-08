package BinaryTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RootToLeafPath {

    public static void main(String[] args) {
       Node root= Node.buildTree();
      int path[]=new int[256];
        List l=new ArrayList();
        Stack<Integer> st=new Stack();
      path(root,st,0);
      System.out.println("===============");
        paths(root,path,0);
    }

    public static void path(Node root,Stack<Integer> l,int pathlen){

        if(root==null)
            return;
       // path[pathlen]=root.data;
        l.push(root.data);
        pathlen++;
        if(root.left==null && root.right==null)
        {
           Object data[]= l.toArray();
            for(int i=0;i<data.length;i++){
                System.out.print(data[i]+" ");
            }
            System.out.println();
            l.pop();
        }
        path(root.left,l,pathlen);
        path(root.right,l,pathlen);

    }

    public static void paths(Node root,int[] path,int pathlen){

        if(root==null)
            return;
         path[pathlen]=root.data;
       // l.push(root.data);
        pathlen++;
        if(root.left==null && root.right==null)
        {

            for(int i=0;i<pathlen;i++){
                System.out.print(path[i]+" ");
            }
            System.out.println();
        }
        paths(root.left,path,pathlen);
        paths(root.right,path,pathlen);

    }
}
