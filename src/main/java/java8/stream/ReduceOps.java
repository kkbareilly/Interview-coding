package java8.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ReduceOps {
    public static void main(String[] args) {
        Student s1 = new Student("Shyam", 22,"A");
        Student s2 = new Student("Ram",23,"A");
        Student s3 = new Student("Mohan",22,"B");
        Student s4 = new Student(null,21,"B");
        List<Student> list = Arrays.asList(s1,s2,s3,s4);
        Comparator<Student> ageComparator = Comparator.comparing(Student::getAge);

        Map<String, Long> eldestByClass = list.stream().collect(Collectors.groupingBy(Student::getClassName,
                Collectors.counting()));
        eldestByClass.forEach((k,v)->System.out.println("Class:"+k+" Age:"+
                v));
    }

    public static class Student {
        private String name;
        private Integer age;
        private String className;
        public Student(String name,Integer age, String className){
            this.name=name;
            this.age=age;
            this.className = className;
        }
        public String getName() {
            return name;
        }
        public Integer getAge() {
            return age;
        }
        public String getClassName() {
            return className;
        }
    }
}
