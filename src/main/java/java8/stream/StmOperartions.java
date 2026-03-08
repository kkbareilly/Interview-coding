package java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StmOperartions {
    public static void main(String[] args) {

        StmOperartions sp=new StmOperartions();
        sp.test(5);
     boolean istrue= getPersons().stream().anyMatch(a->a.getName().equals("RAW"));
    int p= getPersons().stream().map(a->a.getAge()).collect(Collectors.summingInt(s->s));
        Long pt= getPersons().stream().map(a->a.getAge()).collect(Collectors.counting());

        System.out.println(p);
        System.out.println(pt);
        getPersons().stream().collect(
                Collectors.groupingBy(a->a.getAge())
        );

        minMax();
    }




    private static void minMax(){

      StreamOps.Person p=  getPersons().stream().max(Comparator.comparing(StreamOps.Person::getAge)).get();
      System.out.println(p.getName());
        StreamOps.Person p1=  getPersons().stream().min(Comparator.comparing(StreamOps.Person::getAge)).get();
        System.out.println(p1.getName());

        getPersons().stream().map(ps->ps.getAge()).reduce(Integer::min).ifPresent(pl->System.out.println(pl));
    }

    private static List<StreamOps.Person> getPersons(){
        List<StreamOps.Person>list=new ArrayList<>();
        list.add(new StreamOps.Person("kksingh",31));
        list.add(new StreamOps.Person("Ninu",23));

        list.add(new StreamOps.Person("Nano",31));

        list.add(new StreamOps.Person("Raw",31));
        list.add(new StreamOps.Person("plsingh",22));
        return list;
    }
    static class Person {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
        public static List<StreamOps.Person> getList() {
            List<StreamOps.Person> list = new ArrayList<>();
            list.add(new StreamOps.Person("Ram", 30));
            list.add(new StreamOps.Person("Shyam", 20));
            list.add(new StreamOps.Person("Shiv", 20));
            list.add(new StreamOps.Person("Mahesh", 30));
            return list;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof StreamOps.Person)) return false;
            StreamOps.Person person = (StreamOps.Person) o;
            return getAge() == person.getAge() &&
                    Objects.equals(getName(), person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getAge());
        }
    }



//    public void test(int a){
//        System.out.println("Primitive");
//    }
    public void test(Integer a){
        System.out.println("Wrapper");
   }
//    public void test(Float a){
//        System.out.println("Wrapper");
//    }
//    public void test(float a){
//        System.out.println("Primitive");
//    }




}
