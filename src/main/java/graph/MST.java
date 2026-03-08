package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MST {
List<List>  adjList;
boolean visited[];
MST(int nodes){
    adjList=new ArrayList<>();
    visited=new boolean[nodes];
    for(int i=0;i<nodes;i++){
        adjList.add(i,new ArrayList());
    }
}

public void addEdge(int a,int b){
    adjList.get(a).add(b);
    adjList.get(b).add(a);

}

    public  void mst(){

    visited[0]=true;
        Stack st=new Stack();
        st.push(0);
        System.out.println();
        while (!st.isEmpty()){
            int data=(int)st.pop();

            List<Integer> childrens=adjList.get(data);
            for(int dt:childrens){
                if(!visited[dt]){
                    System.out.print(dt);
                    System.out.print(data);
                    System.out.println(" ");
                    visited[dt]=true;
                    st.push(dt);
                }
            }

        }
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
        g.mst();
    }
}

