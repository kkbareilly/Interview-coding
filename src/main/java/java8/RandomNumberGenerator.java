package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumberGenerator {

    public static void main(String[] args) {
        System.out.println(Optional.empty().equals(Optional.ofNullable(null)));
       // Stream.of("").forEach(s->{}).
        Map m=new HashMap();
        String s=new String("A");
        m.put("A",1);
        m.put(s,2);
        String s1=new String("A");
        System.out.println(Arrays.asList(1,2,3,4).stream().filter(i->i==0).collect(Collectors.toList()).size());
System.out.println(Optional.ofNullable(null).isPresent());
        List<?> l=new ArrayList<String>();
       // l.add("a");
        d(5);
    }

    public static  void d(Integer i){
System.out.println("Int");
    }

    public static void d(long i){
        System.out.println("long");

    }
public static int a()
{
   try{ return 1;}catch(Exception e){ return 2;}finally {
       return 3;
   }

}

public void t(){
        a();
}
//
//    int generateRandomNumber(int min, int max) {
//        return (int) ((System.currentTimeMillis() % max) + min);
//    }
//
//    public static void main(String[] args) {
//        RandomNumberGenerator rn = new RandomNumberGenerator();
//        int cv = 0;
//        int min = 1, max = 100;
//        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
//
//        int count = min;
//        while (count <= max) {
//            cv = rn.generateRandomNumber(min, max);
//            if ((hmap.get(cv) == null) && cv >= min && cv <= max) {
//                System.out.print(cv + ",");
//                hmap.put(cv, 1);
//                count++;
//            }
//        }
//
//    }
class s{
    protected  void foo(){}
}
    class p extends  s{
        public  void foo() {
        }
    }
}
