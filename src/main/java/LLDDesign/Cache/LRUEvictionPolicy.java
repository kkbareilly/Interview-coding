package LLDDesign.Cache;

import LRU.LRU;
import LRU.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<key> implements EvictionPolicy<key> {

    Map<key, Node> mapper;
    Node dll;
     LRU lru;
    LRUEvictionPolicy(){
        this.mapper=new HashMap<>();
        this.dll=new Node(null,null);
        lru=new LRU(6);
    }
    @Override
    public void keyAccess(key key) {
        if(mapper.containsKey(key)){
            lru.remove(mapper.get(key));
            lru.setHead(mapper.get(key));
        }else{
          //  mapper.put(key,new Node(key,null))
        }
            //implement get method in LRU
    }

    @Override
    public key evictKey() {
        return null;
    }
}
