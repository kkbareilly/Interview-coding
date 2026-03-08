package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumSpaningWithWeight {

    List<List<Edge>> graph;
    boolean visited[];
    int nodes;

    MinimumSpaningWithWeight(int nodex){
        this.nodes=nodex;
        this.visited=new boolean[nodes];
        this.graph=new ArrayList<>();
        for(int i=0;i<nodes;i++){
            graph.add(i,new ArrayList<>());
        }
    }

    public void addEdge(int source,int target,int distance){
        graph.get(source).add(new Edge(target,distance));
        graph.get(target).add(new Edge(source,distance));

    }

    public int mst(){
        int miniCost=0;
        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                miniCost+=minimumSpaning(i);
            }
        }
        return miniCost;
    }

    public int minimumSpaning(int source){
        PriorityQueue<Edge> que=new PriorityQueue<Edge>((e1, e2)->e1.distance-e2.distance);
        visited[source]=true;
        List<Edge> child=graph.get(source);
        for (Edge edgs:child){
              que.add(edgs);
        }
        int minCost=0;

        while (!que.isEmpty()){
           Edge record= que.poll();

           if(visited[record.target]){
               continue;
           }
           visited[record.target]=true;
           minCost+=record.distance;
           List<Edge> ch=graph.get(record.target);
           for (Edge eg:ch){
               if(!visited[eg.target]){
                    visited[eg.target]=true;
               }
           }
        }
        return minCost;
    }







    class Edge{
        int target;
        int distance;

        Edge(int target,int distance){
            this.target=target;
            this.distance=distance;
        }


        public int getTarget() {
            return target;
        }

        public void setTarget(int target) {
            this.target = target;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}
