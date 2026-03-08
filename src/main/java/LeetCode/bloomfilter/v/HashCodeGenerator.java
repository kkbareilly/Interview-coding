package LeetCode.bloomfilter.v;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class HashCodeGenerator {


    private static class H1Code implements ToIntFunction<Integer>{
      int size;
        H1Code(int size){
            this.size=size;
        }
        @Override
        public int applyAsInt(Integer value) {
            return value%size;
        }
    }

    private static class H2Code implements ToIntFunction<Integer>{
        int size;
        H2Code(int size){
            this.size=size;
        }
        @Override
        public int applyAsInt(Integer value) {
            return (2*value+3)%size;
        }
    }

    public static List<ToIntFunction<Integer>> build(int size){
        return Arrays.asList(new H1Code(size), new H2Code(size));
    }
}
