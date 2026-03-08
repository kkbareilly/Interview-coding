package java8.Comparator;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Cpmparators {

    public static void main(String[] args) {

     Map<Integer,String>map= getPerson().stream().sorted(Comparator.comparing(Person::getId).thenComparing(Person::getName)).collect(Collectors.toMap(Person::getId,Person::getName,(k, v)->k+","+v, HashMap::new));
      /*  getPerson().stream().sorted(Comparator.comparing(Person::getName).thenComparing(Person::getId)).collect(Collectors.toList())
                .forEach(s->System.out.println(s.getId()+"  " +
                        s.getName()));*/

    // getPerson().stream().map(s->s)
      String s=  map.entrySet().stream().map(entry->entry.getValue()).collect(Collectors.joining(",","[","]"));
    map.forEach((k, v) -> System.out.println(k+","+v));
    System.out.println(s);
    }



   static class  Person{

        private int id;
        private String name;

        Person(){}

        Person(int id,String name){
            this.id=id;
            this.name=name;

        }

       public int getId() {
           return id;
       }

       public void setId(int id) {
           this.id = id;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }
   }

    public static List<Person> getPerson(){
        List<Person> p=new ArrayList<>();
       // Person ps=new Person(1,"kk");
        p.add(new Person(1,"kk"));
        p.add(new Person(2,"sl"));

        p.add(new Person(3,"ml"));
        p.add(new Person(4,"kk"));
        p.add(new Person(10,"pk"));
        p.add(new Person(5,"pk"));

        p.add(new Person(6,"ts"));

        return p;
    }
}
