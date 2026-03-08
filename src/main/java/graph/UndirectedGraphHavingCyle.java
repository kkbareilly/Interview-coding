package graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphHavingCyle {

List<List<Integer>> graph;
boolean visited[];
int Max=5;
    UndirectedGraphHavingCyle(){
        visited=new boolean[Max];
        graph=new ArrayList<>();
        for (int i=0;i<Max;i++){
            graph.add(i,new ArrayList<>());
        }
    }
public void addEdge(int start,int end){
        graph.get(start).add(end);
        graph.get(end).add(start);
}

public boolean isCycle(int index,int parent){
          visited[index]=true;
          List<Integer> children=graph.get(index);

          for(Integer child:children){
              if(!visited[child]){
                  isCycle(child,index);
              }else if(child!=parent){
                  return true;
              }
          }
          return false;
}

public boolean isUndirectedGraphHasCycle(){
        for (int i=0;i<5;i++){
            if(!visited[i]){
                return isCycle(i,-1);
            }
        }
        return false;
}


}
