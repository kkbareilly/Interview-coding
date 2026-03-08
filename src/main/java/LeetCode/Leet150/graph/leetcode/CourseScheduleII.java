package LeetCode.Leet150.graph.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {

    List<Integer> adj[];
    boolean visited[];
    boolean explored[];
    Stack<Integer> stk;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
     adj=new ArrayList[numCourses];
     for (int i=0;i<numCourses;i++){
         adj[i]=new ArrayList<>();
     }
     visited=new boolean[numCourses];
     explored=new boolean[numCourses];
     stk=new Stack<Integer>();
     for(int i=0;i<prerequisites.length;i++){
         adj[prerequisites[i][0]].add(prerequisites[i][1]);
     }
     for(int i=0;i<numCourses;i++){
         if(!visited[i]){
             if(isCycle(i)){
                 return new int []{};
             }
         }
     }
     visited=new boolean[numCourses];
     for(int i=0;i<numCourses;i++){
         if(!visited[i]){
             topologicalSort(i);
         }
     }
   /*  int res[]=new int[stk.size()];
     for(int i=0;i<res.length;i++){
         res[i]=stk.pop();
     }*/
     return stk.stream().mapToInt(v->v).toArray();
    }

    private boolean isCycle(int j){
        visited[j]=true;
        for(Integer nbr:adj[j]){
            if(!visited[nbr]){
                if(isCycle(nbr)){
                    return true;
                }
            }else if(!explored[nbr]){
                return true;
            }
        }
        explored[j]=true;
        return false;
    }
    private void topologicalSort(int j){
        visited[j]=true;
        for(int nbr:adj[j]){
            if(!visited[nbr]){
                topologicalSort(nbr);
            }
        }
        stk.push(j);
    }
}
