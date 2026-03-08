package LeetCode.Leet150.graph;

import graph.DFSAdjList;

import java.util.*;

public class MST {

    List<List<Integer>> graph;
    boolean visited[];
    String edge[]=new String[]{"A","B","C","D","E","F"};

    MST(int nodes){
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

    public void mst(int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start]=true;
        while (!stack.isEmpty()){
            int node= stack.pop();
            List<Integer>childs=graph.get(node);
            for(Integer ch:childs){
                if(!visited[ch]){
                    visited[ch]=true;
                    print(edge[node]);
                    print(edge[ch]);
                  System.out.println("    ");
                    stack.push(ch);
                }
            }
        }
    }

    public void print(String v){
        System.out.print(v);
    }

    public static void main(String[] args) {
        MST g=new MST(7);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);

        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.mst(0);
    }
}
