package LeetCode.String;

import java.util.*;
import java.util.stream.Collectors;

public class DesignDataStructure {

    List<Integer> data;
    HashMap<Integer,Integer>indexMap;

    DesignDataStructure()
    {
       data=new ArrayList<>();
       indexMap=new HashMap<>();
    }
    public void add(int key){
        if(indexMap.get(key)!=null)
            return ;
        int size=data.size();
        data.add(key);
        indexMap.put(key,size);

    }
    public void remove(int key){
        Integer index=indexMap.get(key);
        if(index==null)
            return;
        indexMap.remove(key);
        int size=data.size();
        int last= data.get(size-1);
        Collections.swap(data,index,size-1);
     indexMap.put(last,index);
    }

    public  int random(){
        Random rnd=new Random();
        int index=rnd.nextInt(data.size());
        return data.get(index);
    }

    public int search(int key){
       return indexMap.get(key);
    }
}
