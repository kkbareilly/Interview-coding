package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DirectedGraphStronglyConnected {
    List<List> adjlist;
    boolean visited[];
    DirectedGraphStronglyConnected(int nodes){
        adjlist=new ArrayList<>();
        visited=new boolean[nodes];
        for(int i=0;i<nodes;i++)
            adjlist.add(i,new ArrayList());

    }

    public void addEdge(Integer a,Integer b ){
        adjlist.get(a).add(b);
        adjlist.get(b).add(a);
    }

    public boolean connected( int node){
        Stack<Integer> st=new Stack<>();
        st.push(node);
        visited[node]=true;
        while (!st.isEmpty()){
            int data=st.pop();
            List<Integer>childrens=adjlist.get(data);
            for(Integer dt:childrens){
                if(!visited[dt]){
                    visited[dt]=true;
                    st.push(dt);
                }
            }

        }
        for(boolean s:visited){
            if(s==false)
                return s;
        }
        return true;
    }

    public static void main(String[] args) {
        DirectedGraphStronglyConnected g=new DirectedGraphStronglyConnected(7);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);

        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(4,5);
        g.addEdge(4,6);
        for(int i=0;i<7;i++){
            boolean isTrue= g.connected(i);
            System.out.println(isTrue);
            Arrays.fill(g.visited,false);
        }
    }
}
