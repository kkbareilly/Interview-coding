package graph;

import java.util.ArrayList;
import java.util.List;

public class PrintAllThePath {
    private List<List<Integer>> adj;
    boolean visited[];
    int nodes;
    PrintAllThePath(int nodes){
        this.nodes=nodes;
        this.visited=new boolean[nodes];
        adj=new ArrayList<List<Integer>>();
        for(int i=0;i<nodes;i++){
            adj.add(new ArrayList<Integer>());
        }
    }


    public void addEdge(int u, int v)
    {
        // Add v to u's list.
        adj.get(u).add(v);
    }
    public   void printAllPath(int s,int d,List path,boolean visited[]){

        if(d==s){
            path.stream().forEach(p->System.out.print(p));
            System.out.println("");
            return;
        }

        visited[s]=true;
       List<Integer> childrens= adj.get(s);
       for(Integer ch:childrens){
           if(!visited[ch]){
               path.add(ch);
               printAllPath(ch,d,path,visited);
               path.remove(ch);
           }
       }
        visited[s] = false;

    }

    public static void main(String[] args) {
        PrintAllThePath g = new PrintAllThePath(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        // arbitrary source
        int s = 2;

        // arbitrary destination
        int d = 3;

        ArrayList<Integer> pathList = new ArrayList<>();

        // add source to path[]
        pathList.add(s);
       g.printAllPath(s,d,pathList,g.visited);
    }
}
