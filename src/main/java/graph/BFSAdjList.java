package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSAdjList {
    private boolean visited[];
    private List<List<Integer>>graph;

    BFSAdjList(int nodes){
        this.visited=new boolean[nodes];
        this.graph=new ArrayList<>();
        for(int i=0;i<nodes;i++){
            graph.add(i,new ArrayList<>());

        }
    }
    private void addEdge(int start,int end){
        graph.get(start).add(end);
        graph.get(end).add(start);

    }

    public  void bfs(int start){
        visited[start]=true;
     Queue<Integer>    q=new LinkedList();
    q.add(start);
        while (!q.isEmpty()){
            Integer node=q.poll();
            System.out.println(node);
            List<Integer>childrens=graph.get(node);
            for(Integer neighbour:childrens){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.add(neighbour);
                }
            }
        }

    }

    public static void main(String[] args) {
        BFSAdjList g=new BFSAdjList(7);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);

        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.bfs(0);
    }
}
