package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSAdjList {

    private boolean[] visited;
    private List<List<Integer>>graph;
    DFSAdjList(int nodes){
        visited=new boolean[nodes];
        graph=new ArrayList<>();
        for(int i=0;i<nodes;i++){
            graph.add(i,new ArrayList<>());
        }
    }

    public void addEdge(int a,int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public void dfs(int start){
        Stack<Integer> st=new Stack<>();
        st.push(start);
        visited[start]=true;
        while (!st.isEmpty()){
           Integer node=  st.pop();
            System.out.println("Node:" +node);
            List<Integer>childrens= graph.get(node);
          for(Integer child:childrens){
              if(!visited[child]) {
                  visited[child] = true;
                  st.add(child);
              }
          }
        }
    }

    public static void main(String[] args) {
        DFSAdjList g=new DFSAdjList(7);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);

        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(4,5);
        g.addEdge(4,6);
 g.dfs(0);
    }
}
