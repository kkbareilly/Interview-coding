package connectionpool;



    import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TestingCode {

        /*
         * Complete the 'isSimilar' function below.
         *
         * The function is expected to return a BOOLEAN.
         * The function accepts following parameters:
         *  1. STRING_ARRAY sentence_1
         *  2. STRING_ARRAY sentence_2
         *  3. 2D_STRING_ARRAY similarity_matrix
         */

    public static void main(String[] args) {

    }
        public static boolean isSimilar(List<String> sentence_1, List<String> sentence_2, List<List<String>> similarity_matrix) {
            // Write your code here
            boolean result=true;
            int wordCount=0;
            Map<String,List> dataMatch=new HashMap<>();
            for(List data:similarity_matrix){
                List<String> words=(List)data;
                for(String s:words){
                    if(dataMatch.containsKey(s)){
                        List<String> intermediateRecord= dataMatch.get(s);
                        intermediateRecord.addAll(words);
                        dataMatch.put(s, intermediateRecord);

                    }else{
                        dataMatch.put(s, words);
                    }
                }
            }
            for(int i=0;i<sentence_1.size()-1;i++){
                if(dataMatch.containsKey(sentence_1.get(i))){
                    List<String> data=dataMatch.get(sentence_1.get(i));
                    if(data.contains(sentence_2.get(i))){
                        continue;
                    }else{
                        for(String second:data){
                            List<String> secondData=dataMatch.get(second);
                            if(secondData.contains(sentence_2.get(i))){
                                continue;
                            }else{
                                result=false;
                            }

                        }

                    }
                }
            }

            return result;
        }

    }

