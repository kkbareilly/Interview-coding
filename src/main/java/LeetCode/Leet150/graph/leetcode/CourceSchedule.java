package LeetCode.Leet150.graph.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CourceSchedule {

    List<Integer>[] adj;
    boolean visited[];
    boolean marked[];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited=new boolean[numCourses];
        marked=new boolean[numCourses];
        adj=new ArrayList[numCourses];
     for(int i=0;i<numCourses;i++){
         adj[i]=new ArrayList<>();
     }
     for(int i=0;i<prerequisites.length;i++){
         adj[prerequisites[i][0]].add(prerequisites[i][1]);
     }
     for(int i=0;i<numCourses;i++){
         if(!visited[i]){
             if(isCycle(i)){
                 return false;
             }
         }
     }
     return true;
    }

    private boolean isCycle(int i){
      visited[i]=true;
      for(int nbr:adj[i]){
          if(!visited[nbr]){
              if(isCycle(nbr)){
                  return true;
              }

          }else if(!marked[nbr]){
              return true;
          }
      }
      marked[i]=true;
      return false;
    }

    //solution 2

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
       List<List<Integer>> adj=new ArrayList<>();
       int visited[]=new int[numCourses];
       int inStack[]=new int[numCourses];
       for(int i=0;i<numCourses;i++){
      adj.add( new ArrayList<>());
       }

       for(int ar[]:prerequisites){
           adj.get(ar[0]).add(ar[1]);
       }
       for(int i=0;i<numCourses;i++){
           if(cycle(adj,inStack,visited,i))
                  return false;
       }
       return true;
    }
   public boolean cycle(List<List<Integer>>adj,int instack[],int visited[],int index){

        if(instack[index]==1)
            return true;
        if(visited[index]==1)
             return false;
        instack[index]=1;
        visited[index]=1;
        for(int nvr:adj.get(index)){
            if (cycle(adj,instack,visited,nvr))
                return true;
        }
        instack[index]=0;
        return false;
   }

}
