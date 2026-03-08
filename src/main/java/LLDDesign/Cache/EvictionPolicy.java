package LLDDesign.Cache;

public interface EvictionPolicy<key> {
    public void keyAccess(key key);

    key evictKey();
}
