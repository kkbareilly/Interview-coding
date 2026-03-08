package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimesAlgo {

    List<List<Edge>> graph;
    boolean visited[];
    int NUMBER_OF_NODES;
    int mincost=0;
    PrimesAlgo(int node){
        this.NUMBER_OF_NODES=node;
        visited=new boolean[node];
        graph=new ArrayList<>();
        for(int i=0;i<node;i++){
            graph.add(i,new ArrayList<>());
        }
    }

    public void addEdge(int start,int target,int distance){
        graph.get(start).add(new Edge(target,distance));
        graph.get(target).add(new Edge(start,distance));

    }


    public int prims(int source){
        PriorityQueue<Edge> queue=new PriorityQueue<Edge>((e1,e2)->e1.distance-e2.distance);
      List<Edge> chld= graph.get(source);
      for (Edge e:chld){
          queue.add(e);
      }
      while (!queue.isEmpty()){
         Edge node= queue.poll();
         if(visited[node.node])
             continue;
         visited[node.node]=true;
        List<Edge>childrens =graph.get(node.node);
        mincost=mincost+node.distance;
        for(Edge edge:childrens){
            if(!visited[edge.node]){
                queue.add(edge);
            }
        }
      }
      return mincost;
    }
}



