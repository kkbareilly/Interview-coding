package LeetCode.bloomfilter.v;

import LeetCode.bloomfilter.BloomFilter;

import java.util.List;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class CustomBloomFilter implements BloomFilter {

    private int arr[];
    private int size;
    private List<ToIntFunction<Integer>> functions;

 CustomBloomFilter(int size) throws Exception {
     if(Integer.bitCount(size)!=1)
         throw  new Exception("");
     this.size=size;
     this.arr=new int[size];
     functions=HashCodeGenerator.build(size);
 }
    @Override
    public void Add(Object value) {
          for (ToIntFunction function:functions){
             int position= function.applyAsInt(value);
             arr[position]=1;
          }
    }

    @Override
    public boolean mightContain(Object key) {
     int hash[]=new int[functions.size()];
     int i=1;
        for (ToIntFunction function:functions){
            int position= function.applyAsInt(key);
            hash[i]=arr[position];
            i++;
        }
        return (hash[0]==1&&hash[1]==1);
    }
}
