package graph;

import java9.CodeTest;

import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSort {

    List<List<Integer>> graph;
    Map<Integer,Integer> indegree;
    int nodes;
    Queue<Integer> soruce;

    TopologicalSort(int nodes){
        graph=new ArrayList<>();
        this.nodes=nodes;
        indegree=new HashMap<>();
        soruce=new LinkedList<>();
        for (int i=0;i<nodes;i++){
            graph.add(i,new ArrayList<>());
            indegree.put(i,0);
        }
    }

    public void addEdge(int a,int b){
        graph.get(a).add(b);
        indegree.putIfAbsent(b,indegree.getOrDefault(b,0)+1);
    }
    public List<Integer> topology(){
        soruce= indegree.entrySet().stream().filter(e->e.getValue()==0).map(e->e.getKey()).collect(Collectors.toCollection(LinkedList::new));
     List<Integer> result=new ArrayList<>();
        while (!soruce.isEmpty()){
             Integer data=soruce.remove();
             result.add(data);
             List<Integer> childs=graph.get(data);
             for(Integer child:childs){
                 if(indegree.get(child)==0){
                     soruce.add(child);
                 }
                 indegree.put(child,indegree.get(child)-1);
             }
        }
        if (result.size()!=nodes){
            System.out.println("Cycle exit");
            return new ArrayList<>();
        }
        return result;
    }
}
