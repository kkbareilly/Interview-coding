package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DirectedGraphHavingCycle {

    List<List<Integer>> graph;
     boolean visited [];
     boolean recursiveStack[];
     int nodes;
    DirectedGraphHavingCycle(int size){
        this.nodes=size;
        visited=new boolean[size];
        recursiveStack=new boolean[size];
        graph=new ArrayList<>();
        for (int i=0;i<size;i++){
            graph.add(i,new ArrayList<>());
        }
    }
    public void addEdge(int start,int end){
        graph.get(start).add(end);
    }

    public boolean ifDirectedGraphHasCycle(){
        for (int i=0;i<nodes;i++){
           if( isCycle(i)){
               return true;
           }
        }
        return false;
    }
    public boolean isCycle(int index){
        if (recursiveStack[index])
            return true;
        if (visited[index])
            return false;
        visited[index]=true;
        recursiveStack[index]=true;
        List<Integer>children=graph.get(index);
        for(Integer child:children){
            if(isCycle(child))
                return true;
        }
        recursiveStack[index]=false;
        return false;
    }
}
