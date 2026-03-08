package Algo;

import java.util.*;

public class RearrangeNumberToFormLargestNumber {

    public static void main(String[] args) {
        List<String> l=new ArrayList();
        l.add("3");
        l.add("6");
        l.add("1");
        l.add("9");
        l.add("4");
        printLarge(l);

    }

    public static void printLarge(List<String> a){

        Collections.sort(a,new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy=x+y;
                String yx=y+x;
                return xy.compareTo(yx)>0?-1:1;
            }

        });

        a.stream().forEach(data->System.out.println(data));
    }
}
