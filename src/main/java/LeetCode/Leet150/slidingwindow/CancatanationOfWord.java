package LeetCode.Leet150.slidingwindow;
/**
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 *
 * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
 *
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
 * Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CancatanationOfWord {

    public List<Integer> findSubstring(String s, String[] words) {
          if(s==null || s.length()==0 ||words==null || words.length==0)
              return new ArrayList<>();
        Map<String,Integer> freqMap=new HashMap<>();
        List<Integer> result=new ArrayList<>();
        for (String word : words){
               freqMap.put(word,freqMap.getOrDefault(word,0)+1);
        }
        int totalWord=words.length;
        int wordLength=words[0].length();
        for(int i=0;i<s.length()-totalWord*wordLength;i++){

            Map<String,Integer>seenMap=new HashMap<>();
            for(int j=0;j<words.length;j++){
                int wordIndex=i+j*wordLength;
                String word=s.substring(wordIndex,wordIndex+wordLength);
                if(!freqMap.containsKey(word)){
                    break;
                }
                seenMap.put(word,seenMap.getOrDefault(word,0)+1);
                if(seenMap.get(word)>freqMap.getOrDefault(word,0)){
                    break;
                }
                if(j+1==totalWord)
                    result.add(i);
            }
        }
        return result;
    }
}
