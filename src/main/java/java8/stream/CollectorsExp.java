package java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsExp {

    public static void main(String[] args) {
     //   Object data=Person.getPerson().stream().collect(Collectors.collectingAndThen(Collectors.summarizingDouble(Person::getSalary),s->s.));
      //  System.out.println(data);
        averaging();
        collectingAndThen();
    }
    private static void averaging(){
        System.out.println( Person.getPerson().stream().collect(Collectors.averagingDouble(e->e.salary*2)));
        System.out.println(Person.getPerson().stream().collect(Collectors.counting()));
        System.out.println(Person.getPerson().stream().map(e->e.name).collect(Collectors.joining(",","(",")")));
       Optional<Person> person= Person.getPerson().stream().collect(Collectors.maxBy(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        }));
        System.out.println(person.get().id);
        System.out.println(Person.getPerson().stream().collect(Collectors.summarizingDouble(Person::getSalary)).getSum());
        System.out.println(Person.getPerson().stream().collect(Collectors.summingDouble(Person::getSalary)));

    }
    private static void collectingAndThen(){
        double data1=Person.getPerson().stream().collect(Collectors.collectingAndThen(Collectors.averagingDouble(e->e.salary*2),(data)->data*4));
        System.out.println( data1);
    }
}

class Person{
    Long id;
    Double salary;
    String name;
    String department;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static List<Person> getPerson(){
        List<Person> list=new ArrayList<>();
        Person p=new Person();
        p.setId(1l);
        p.setName("kk");
        p.setSalary(123456.0);
        p.setDepartment("ENG");
        Person p1=new Person();
        p1.setId(1l);
        p1.setName("pk");
        p1.setSalary(23434.0);
        p1.setDepartment("ENG");
        list.add(p);
        list.add(p1);
        return list;
    }
}