package LeetCode.Leet150.graph;

import javax.management.Query;
import java.util.*;

public class DBSBFSUsingAdjList {
    List<List<Integer>> graph;
    boolean visited[];

    DBSBFSUsingAdjList(int nodes){
        graph=new ArrayList<>();
        visited=new boolean[nodes];
        for(int i=0;i<nodes;i++){
            graph.add(i,new ArrayList<>());
        }
    }

    public void addEdge(int a,int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public void bfs(int start){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        visited[start]=true;
        while (!queue.isEmpty()){
           int node= queue.poll();
           List<Integer>childs=graph.get(node);
           for(Integer ch:childs){
               if(!visited[ch]){
                   visited[ch]=true;
                   queue.add(ch);
               }
           }
        }
    }

    public void dfs(int start){
    Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start]=true;
        while (!stack.isEmpty()){
            int node= stack.pop();
            List<Integer>childs=graph.get(node);
            for(Integer ch:childs){
                if(!visited[ch]){
                    visited[ch]=true;
                    stack.push(ch);
                }
            }
        }
    }
}
