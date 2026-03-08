package LeetCode.Leet150.graph.leetcode.bfs;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumGenericMutation {

    class Pair{
        String genre;
        int mutations;
        Pair(int mutations,String genre){
            this.genre=genre;
            this.mutations=mutations;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {

        HashSet set=new HashSet(Arrays.asList(bank));
        if(!set.contains(endGene)) return -1;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(0,startGene));
       while (!q.isEmpty()){
           Pair p=q.poll();
           if(p.genre.equals(endGene)) return p.mutations;
           Character []c=new Character[]{'A','C','G','T'};
           StringBuilder sb=new StringBuilder(p.genre);
           for(int i=0;i<p.genre.length();i++){
               char temp=sb.charAt(i);
               for(char ch:c){
                   if(ch!=temp){
                       sb.replace(i,i+1,ch+"");
                        if (set.contains(sb.toString())) {
                         q.add(new Pair(p.mutations + 1, sb.toString()));
                         set.remove(sb.toString());
                           }
                   }
               }
               sb.replace(i,i+1,temp+"");
           }
       }
        return -1;

    }



    public int bfs(String startGene, String endGene, String[] bank){
        Set<String> bankSet = getBankSet(bank);
        Set<String> visited = new HashSet<>();
        char[] geneChars = {'A','C','G','T'};
        Deque<String> q = new ArrayDeque<>();
        q.add(startGene);
        int mutations=0;

        while(!q.isEmpty()){
            int qSize = q.size();
            for(int s=0;s<qSize;s++){
                String currGene = q.remove();
                if(currGene.equals(endGene))
                    return mutations;
                for(char geneChar : geneChars){
                    for(int i=0; i<currGene.length();i++){
                        char[] nextGeneChars = currGene.toCharArray();
                        nextGeneChars[i] = geneChar;
                        String nextGene = new String(nextGeneChars);
                        if(!bankSet.contains(nextGene) || visited.contains(nextGene)) continue;
                        visited.add(nextGene);
                        q.add(nextGene);
                    }
                }
            }
            mutations++;
        }
        return -1;
    }

    public Set<String> getBankSet(String[] bank){
        return Arrays.stream(bank)
                .collect(Collectors.toSet());
    }


}
