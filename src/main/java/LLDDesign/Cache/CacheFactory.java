package LLDDesign.Cache;

public class CacheFactory<key,value> {

    public Cache<key,value> defaultCache(Storage s,EvictionPolicy e){
        return new Cache<key,value>(e,s);
    }
}
