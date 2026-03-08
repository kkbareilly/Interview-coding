package LeetCode.Leet150.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphDepthAdj {
    Vertex[] vertex;
    int adjMax[][];
    int verx=0;
    int maxVertex=20;
    Stack<Integer> st;
    Queue<Integer>queue;
    GraphDepthAdj(){
          vertex=new Vertex[maxVertex];
          adjMax=new int[maxVertex][maxVertex];
          verx=0;
        st=new Stack();
        queue=new LinkedList<>();
    }

    public void addEdge(int v){
        vertex[verx++]=new Vertex(v);
    }
    public void addNode(int start,int end){
        adjMax[start][end]=1;
        adjMax[end][start]=1;
    }

    public void dfs(){
        vertex[0].isVisited=true;
        st.push(0);

        while (!st.isEmpty()){
          int v=getUnvisitedIndex(st.peek());
          if(v==-1)
              st.pop();
          else{
              vertex[v].isVisited=true;
              st.push(v);
          }

        }
    }

    public void bfs(){
        vertex[0].isVisited=true;
        queue.add(0);
        int v1=0;
        while (!queue.isEmpty()){

            int v=queue.remove();

                 if( (v1=getUnvisitedIndex(v))!=-1){
                vertex[v1].isVisited=true;
                st.push(v1);
            }

        }
    }

    public int getUnvisitedIndex(int v){
        for(int i=0;i<verx;i++){

           if( adjMax[v][i]==1&&vertex[i].isVisited==false){
               return i;
           }
        }
        return -1;
    }

    public void mst(){
        vertex[0].isVisited=true;
        st.push(0);

        while (!st.isEmpty()){
           int node= st.peek();
            int v=getUnvisitedIndex(node);
            if(v==-1)
                st.pop();
            else{
              System.out.println(vertex[node].data);
                System.out.println(vertex[v].data);
                vertex[v].isVisited=true;
                st.push(v);
            }

        }
    }

}




class Vertex{
    int data;
    boolean isVisited=false;

    public Vertex(int data) {
        this.data = data;
        this.isVisited = false;
    }
}
