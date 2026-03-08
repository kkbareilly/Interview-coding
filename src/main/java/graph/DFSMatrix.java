package graph;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSMatrix {
    private final int VERS_MAT=20;
    private Vertext vertex[];
    private int adjMat[][];

    private int nVerts;
    Stack<Integer>s;
    Queue<Integer>q;
    DFSMatrix(){
      this.vertex=new Vertext[VERS_MAT];
      adjMat=new int[VERS_MAT][VERS_MAT];
      nVerts=0;
      s=new Stack<>();
      q=new LinkedList<>();
    }
    public  void addVertex(char vertx)
    {

        vertex[nVerts++]=new Vertext(vertx,false);
    }
    public void addEdge(int start ,int end){
      adjMat[start][end]=1;
        adjMat[end][start]=1;

    }

    public void bfs(){
        vertex[0].wasVisited=true;
        displayVertex(0);
        q.add(0);
        int v2;
        while (!q.isEmpty()){
            int v1=q.remove();
            while((v2=getUnVisitedVertex(v1))!=-1){
                vertex[v2].wasVisited=true;
                displayVertex(v2);
                q.add(v2);
            }
        }
    }
    public  void dfs(){
        vertex[0].wasVisited=true;
        displayVertex(0);
        s.push(0);
        while (!s.isEmpty()){
            int ver=getUnVisitedVertex(s.peek());
            if(ver==-1){
                s.pop();
            }else {
                vertex[ver].wasVisited=true;
                displayVertex(ver);
                s.push(ver);
            }
        }
    }

    private int getUnVisitedVertex(int peek) {

        for(int i=0;i<nVerts;i++){
            if(adjMat[peek][i]==1 && vertex[i].wasVisited==false){
                return i;
            }
        }
        return -1;
    }


    public void mst(){
        vertex[0].wasVisited=true;
        s.push(0);

        while (!s.isEmpty()){
            int current=s.peek();
             int v1=getUnVisitedVertex(current);
             if(v1==-1)
                 s.pop();
             else{
                 vertex[v1].wasVisited=true;
                 System.out.print(current);
                 System.out.print(v1);
                 System.out.println("");
                 s.push(v1);

             }
        }
    }
    public void displayVertex(int v){
        System.out.println(vertex[v].level);
    }

    public static void main(String[] args) {
        DFSMatrix graph=new DFSMatrix();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
       // graph.addVertex('G');

//        graph.addEdge(0,1);
//        graph.addEdge(1,2);
//        graph.addEdge(0,3);
//        graph.addEdge(3,4);
//        graph.addEdge(4,5);
//        graph.addEdge(1,3);


        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(1,4);
//graph.dfs();
System.out.println("##################");
graph.bfs();
    }

}
