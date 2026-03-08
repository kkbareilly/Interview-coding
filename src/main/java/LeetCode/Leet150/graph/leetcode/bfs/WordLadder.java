package LeetCode.Leet150.graph.leetcode.bfs;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) return 0;
        Map<String,Boolean>vmap=new HashMap<>();
        for(String wor:wordList)
            vmap.put(wor,false);
        Queue<String> q=new LinkedList();

        q.add(beginWord);
        int length=1;
        vmap.put(beginWord,true );

        while (!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
               String curr=q.poll();
               if(curr.equals(endWord)) return length;
                matchWord(curr,vmap,q);
            }
            length++;
        }
       return 0;
    }

    public void matchWord(String word,Map<String,Boolean> vmap,Queue q){
        for (int i=0;i<word.length();i++){
            char[] nexGen=word.toCharArray();
            for(int j=0;j<26;j++){
                char temp=(char)('a'+j);
                nexGen[i]=temp;
                String s=String.valueOf(nexGen);
                if(vmap.containsKey(s)&&vmap.get(s)==false){
                    q.add(s);
                   vmap.put(s,true);
               }
            }
        }

    }


    public int ladderLengths(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList), beginSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> tempSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) {
                            return len + 1;
                        }
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            tempSet.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = tempSet;
            len++;
        }
        return 0;
    }
}
