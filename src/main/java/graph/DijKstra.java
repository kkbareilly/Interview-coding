package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijKstra {
    public static void main(String[] args) {
        //
       // Graph graph1=new Graph(5);
        DijKstra dg=new DijKstra(5);
        dg.addEdge(0,1,1);
        dg.addEdge(0,2,7);
        dg.addEdge(1,2,5);
        dg.addEdge(1,4,4);
        dg.addEdge(4,3,2);
        dg.addEdge(2,3,6);
        System.out.println(
                dg.minimumDistance(1,4));
    }
    List<List<Edge>> graph=null;
    int distance[];
    boolean visited[];

    public void addEdge(int source,int destination,int distance){
        graph.get(source).add(new Edge(destination,distance));
    }

    public int minimumDistance(int source,int destination){
        if (source==destination)
            return 0;
        PriorityQueue<Edge> minHeap=new PriorityQueue<>((e1, e2)->e1.distance-e2.distance);
        distance[source]=0;
        minHeap.add(new Edge(source,0));
        while (!minHeap.isEmpty()){
            int node=minHeap.poll().index;
            if (visited[node])
                continue;
            visited[node]=true;
            List<Edge> childNodes=graph.get(node);
            for (Edge child:childNodes){
                if(!visited[child.index] && distance[node]+child.distance<distance[child.index]){
                    distance[child.index]=distance[node]+child.distance;
                    child.distance=distance[node]+child.distance;
                    minHeap.add(child);
                }

            }

        }
        return distance[destination];
    }


    class Edge{
        int index;
        int distance;
        Edge(int index,int distance){
            this.index=index;
            this.distance=distance;
        }
    }
    DijKstra(int nodes){
        graph=new ArrayList<>();
        distance=new int[nodes];
        visited=new boolean[nodes];
        for(int i=0;i<nodes;i++){
            graph.add(i,new ArrayList<>());
            distance[i]=Integer.MAX_VALUE;
        }
    }
}
