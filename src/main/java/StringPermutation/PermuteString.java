package StringPermutation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PermuteString {

    public static void main(String[] args) {
        String s="xyz";
        PermuteString ps=new PermuteString();
        ps.permute(s.toCharArray());
    }


    public void permute(char []input){

        Map<Character,Integer> map=new TreeMap<>();

        for(char ch:input){

            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else {
                map.put(ch,1);
            }
        }
        int index=0;
        char str[]=new char[map.size()];
        int count[]=new int[map.size()];
        char result[]=new char[input.length];
       for(Map.Entry entry:map.entrySet()){
            str[index]=(char)entry.getKey();
            count[index]=(int)entry.getValue();
            index++;
        }

        permuteUtil(str,count,result,0);

    }

    public void permuteUtil(char[]str,int count[],char result[],int level){

        if(level==result.length){
             print(result);
             return;
        }
         for(int i=0;i<str.length;i++){
             if(count[i]==0)
                 continue;
             result[level]=str[i];
             count[i]--;
             permuteUtil(str,count,result,level+1);
             count[i]++;
         }
    }

    public void print(char []result){

        Map map=new HashMap();
        map.computeIfPresent(102,(k,v)-> v!=null?"":null);
        for(char rs:result){
            System.out.print(rs);
        }
        System.out.println(" ");
    }
}
