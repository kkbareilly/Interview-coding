package graph;

import java.util.*;

public class Path {

    public static void main(String[] args) {
        boolean isEnd=false;

        while (isEnd){
            Scanner scanner = new Scanner(System.in);
            String line=scanner.next();
            String[]data=line.split(" ");
            for(String s:data){
                Node node=new Node(data[0],data[1],data[2],data[3]);
            }

        }
    }
}

class GraphNode{
    Map<String,List<Node>> adjMap;

    public GraphNode(){
        adjMap=new HashMap<>();
    }
    public void  addNode(Node node){
       if(getAdjMap().containsKey(node.getLabel())){
           List<Node>lst=getAdjMap().get(node.getLabel());
           lst.add(node);
           if(getAdjMap().containsKey(node.gotilabel)){
               lst.add(getAdjMap().get(node.gotilabel).get(0));
           }
         getAdjMap().put(node.getLabel(),lst);
       }else{
           List lst=new ArrayList();
           lst.add(node);
           if(getAdjMap().containsKey(node.gotilabel)){
               lst.add(getAdjMap().get(node.gotilabel).get(0));
           }
           getAdjMap().put(node.getLabel(),lst);
       }
    }

    public Map<String, List<Node>> getAdjMap() {
        return adjMap;
    }

    public void setAdjMap(Map<String, List<Node>> adjMap) {
        this.adjMap = adjMap;
    }
}

class Node{
    String label;
    String question;
    String answer;
    String gotilabel;

    public Node(String label, String question, String answer, String gotilabel) {
        this.label = label;
        this.question = question;
        this.answer = answer;
        this.gotilabel = gotilabel;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getGotilabel() {
        return gotilabel;
    }

    public void setGotilabel(String gotilabel) {
        this.gotilabel = gotilabel;
    }
}