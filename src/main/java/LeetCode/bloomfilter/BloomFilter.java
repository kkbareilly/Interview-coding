package LeetCode.bloomfilter;

public interface BloomFilter<T> {

    public void Add(T value);
    boolean mightContain(T key);
}
