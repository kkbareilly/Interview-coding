package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MSTUsingAdjList {

    List<List<Character>> adjList;
    Vertext visited[];
   int  nvertx=0;
    MSTUsingAdjList(int vertex){

        this.adjList=new ArrayList<>();
        this.visited=new Vertext[vertex];

        for(int i=0;i<vertex;i++){
            adjList.add(i,new ArrayList<Character>());
        }
    }

    public void addEdge(Character a,Character b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
    public void addVertex(Character vale){
        visited[nvertx++]=new Vertext(vale,false);
    }

    public  void dfs(){
        visited['a'].wasVisited=true;
        Stack<Character> st=new Stack();
        st.push('a');
        while (!st.isEmpty()){
            Character current=st.pop();
            List<Character>childrens=adjList.get(current);
            for(Character child:childrens){
                if(!visited[child].wasVisited){
                    visited[child].wasVisited=true;
                    System.out.print(current+child);
                    System.out.print("  ");
                    st.push(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        MSTUsingAdjList g=new MSTUsingAdjList(7);

        g.addVertex('a');
        g.addVertex('b');
        g.addVertex('c');
        g.addVertex('d');
        g.addVertex('e');
        g.addVertex('f');
        g.addVertex('g');
        g.addEdge('a','b');
        g.addEdge('a','c');
        g.addEdge('b','d');

        g.addEdge('c','e');
        g.addEdge('d','f');
        g.addEdge('e','f');
        g.addEdge('d','g');
        g.dfs();
    }
}
