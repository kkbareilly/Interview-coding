package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOfConnectedComponentANDIsCyleExist {


    public static void main(String[] args) {
        NumberOfConnectedComponentANDIsCyleExist nc=new NumberOfConnectedComponentANDIsCyleExist(7);
        nc.addEdges(0,1);
        nc.addEdges(0,2);

        nc.addEdges(1,3);

        //nc.addEdges(2,4);

       // nc.addEdges(5,4);

        //5nc.addEdges(4,5);

        nc.addEdges(4,6);

      // System.out.println(nc.countConnected()); ;
        System.out.println(nc.isPathExist(0,6)); ;


    }
    List<List<Integer>>  adjList;
    boolean visited[];
    int nodes;
    Stack st;

    NumberOfConnectedComponentANDIsCyleExist(int nodes){

        this.nodes=nodes;
        adjList=new ArrayList<List<Integer>>();
        visited=new boolean[nodes];
st=new Stack();
        for(int i=0;i<nodes;i++){
            adjList.add(i,new ArrayList<Integer>());
        }
    }


    public void addEdges(int a,int b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);

    }


    public void dfs(int i){
        visited[i]=true;
        st.push(i);

        while (!st.isEmpty()){

            Integer data=(Integer) st.pop();

            List childrens=adjList.get(data);

            for(Object ss:childrens){
                if(!visited[Integer.parseInt(ss.toString())]){
                    visited[Integer.parseInt(ss.toString())]=true;
                    st.push(Integer.parseInt(ss.toString()));
                }

            }

        }
    }


    public int countConnected(){
        int count=0;
        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        return count;
    }

    public boolean isPathExist(int source,int destincation){
        dfs(source);
        //destination should be visited while dfs(directed and undirected both)
        if(visited[destincation]){
            return true;
        }
        return false;
    }

    public boolean isCycleExistInNonDirected(){

        for(int i=0;i<nodes;i++){
            if(!visited[i]){
               if(dfs(i,-1))
                   return true;
            }
        }
        return false;
    }
    public boolean dfs(int index,int parent){
        visited[index]=true;
        List<Integer> neighbours=adjList.get(index);

        for(Integer a:neighbours){
            if(!visited[a])
                dfs(a,index);
            else if(parent!=a)
                return true;
            }
        return false;
        }

}
