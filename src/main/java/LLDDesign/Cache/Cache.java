package LLDDesign.Cache;

import LRU.Node;

public class Cache<key,value> {
    EvictionPolicy<key> evictionPolicy;
    Storage<key,value> storage;
    Cach1`e(EvictionPolicy e,Storage s){
        this.evictionPolicy=e;
        this.storage=s;

    }

    public void put(key key,value value) throws Exception {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccess(key);
        }catch (Exception e){
            System.out.println("got Storage full");
           key keyToRemove= evictionPolicy.evictKey();
           if(keyToRemove==null){
                throw new Exception("unexpected error");
           }
           storage.remove(keyToRemove);
           put(key,value);
        }
    }

    public Node get(key key){
        Node n=(Node)this.storage.get(key);
        this.evictionPolicy.keyAccess(key);
        return n;
    }
}
