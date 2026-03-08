package LLDDesign.Cache;

import java.util.HashMap;
import java.util.Map;

public class HashMapBaesStorage<key,value> implements Storage<key,value>{

    Map<key,value> mp=new HashMap<>();
    @Override
    public void add(key k, value v) {

        mp.put(k,v);
    }

    @Override
    public Object get(key key) {
        return mp.get(key);
    }

    @Override
    public void remove(key key) {
        mp.remove(key);
    }
}
