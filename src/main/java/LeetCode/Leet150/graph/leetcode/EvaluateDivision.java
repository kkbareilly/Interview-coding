package LeetCode.Leet150.graph.leetcode;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Node>>adj=new HashMap<>();

        for(int i=0;i<values.length;i++){
            List<String>edage=equations.get(i);
           List<Node> nbr=adj.getOrDefault(edage.get(0),new ArrayList<>());
            nbr.add(new Node(edage.get(1),values[i]));
            adj.put(edage.get(0),nbr);

          nbr=adj.getOrDefault(edage.get(1),new ArrayList<>());
            nbr.add(new Node(edage.get(0),1/values[i]));
            adj.put(edage.get(1),nbr);
        }
        double[] ans=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            List<String>query=queries.get(i);
            if(adj.containsKey(query.get(0))&& adj.containsKey(query.get(1))){
                ans[i]=solve(query.get(0),query.get(1),1.0,new HashSet<>(),adj);
            }else{
                ans[i]=-1.0;
            }
        }
       return ans;
    }

    public double solve(String source,String target,double ans, HashSet visit,Map<String,List<Node>> adj){
        if(visit.contains(source)) return -1.0;
        if(source.equals(target)) return ans;
        visit.add(source);
        for(Node neighor: adj.getOrDefault(source,new ArrayList<>())){
            double val=solve(neighor.val,target,ans*neighor.w,visit,adj);
            if(val!=-1)
                return val;
            }
           return -1.0;
        }


    class Node{

        String val;
        double w;
        Node(String val,double w){
            this.val=val;
            this.w=w;

        }
    }
}
