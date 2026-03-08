package LLDDesign.Cache;

public interface Storage<key,value> {

    public void add(key k,value v);
    public Object get(key key);
    public void  remove(key key);

}
