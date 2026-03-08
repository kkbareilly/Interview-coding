package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDistanceBetweenStoD {

    boolean visited[];
    List<List<Integer>> adjList;
    int nodes;
    MinimumDistanceBetweenStoD(int nodes){
        this.nodes=nodes;
        visited=new boolean[nodes];
        this.adjList=new ArrayList<>();
        for(int i=0;i<nodes;i++){
            adjList.add(i,new ArrayList<>());
        }
    }

    public void addEdge(int start,int end){
        adjList.get(start).add(end);
        adjList.get(end).add(start);
    }

    public int minDistance(int source,int destination){

        if(source==destination)
            return 0;

        Queue<Integer> q=new LinkedList();
        q.add(source);
        visited[source]=true;
        int minDist=0;
        while (!q.isEmpty()){
            int size=q.size();

            while (size>0){
                int data=q.poll();
                List<Integer> childrens=adjList.get(data);
                for(Integer child:childrens){
                    if(child==destination){
                       return  ++minDist;
                    }
                    if(!visited[child]){
                            visited[child]=true;
                            q.add(child);
                        }
                   // }
                }
                size--;
            }
            minDist++;
        }
        return minDist;
    }

    public static void main(String[] args) {
        MinimumDistanceBetweenStoD g=new MinimumDistanceBetweenStoD(7);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);

        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(4,5);
        g.addEdge(4,6);
       System.out.println( g.minDistance(2,6));
    }
}
