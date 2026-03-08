package Algo;



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



   public class Result {

        /*
         * Complete the 'onesGroups' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. 2D_INTEGER_ARRAY grid
         *  2. INTEGER_ARRAY queries
         */
        public static void main(String[] args) {
            
        }
        public static List<Integer> onesGroups(List<List<Integer>> grid, List<Integer> queries) {
            // Write your code here
            int count=0;
            ArrayList list=new ArrayList<>();
            Map<Integer,Integer> map=new HashMap();
            for(int i=0;i<grid.size();i++){
                List<Integer>  child=grid.get(i);
                for(Integer  a:child){
                    count=count+1;
                    List<Integer>  subChild=grid.get(a);
                    for(Integer sub:subChild){
                        count=count+1;
                    }

                }
                if(queries.contains(count)){
                    if(map.containsKey(count)){
                        map.put(count, map.get(count)+1);
                    }else{
                        map.put(count, 1);
                    }
                }
            }
            for(Integer q:queries){
                list.add(map.get(q));
            }

            return list;
        }

    }



