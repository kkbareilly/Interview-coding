package LeetCode.Leet150.arraystring;

import java.util.*;

public class InsertDeleteGetRandom {


    Random rand=new Random();
    ArrayList<Integer> arr;
    Map<Integer,Integer> map;
    public InsertDeleteGetRandom() {
        arr=new ArrayList<Integer>();
        map=new HashMap<Integer,Integer>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            System.out.println(" map size "+ map.size() +"Val "+ val);
            return false;
        }
        int size=arr.size();
        arr.add(val);
        map.put(val,size);
        return true;
    }
    public boolean remove (int val) {

        if(!map.containsKey(val))
            return false;
        Integer index=map.get(val);
        if(index<arr.size()-1){
            Integer size=arr.size();
            Integer last=arr.get(size-1);
            arr.set(index,last);
            map.put(last,index);
        }
        map.remove(val);
        arr.remove(arr.size()-1);


        return true;
    }

    public int getRandom() {

        return arr.get(rand.nextInt(arr.size()));
    }

}
