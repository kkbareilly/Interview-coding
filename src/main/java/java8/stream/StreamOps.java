package java8.stream;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOps {

    static void buildRecordList(List<String>members,List<Object> result,int i)
    {
        String type="";

        if (type.equals("ENTITY")) // base case
            return ;
        else {
            result.add(members.get(i+1));
        }
    }

    public  void Ops(){
        getPersons().stream().max(Comparator.comparing(String::valueOf))
                .ifPresent(e -> System.out.println("Max: " + e));
    }

    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(42, 44, 43, 41);

        //For min
        numList.stream().reduce(Integer::min).ifPresent(s -> System.out.println(s)); //41
        //For max
        numList.stream().reduce(Integer::max).ifPresent(s -> System.out.println(s)); //44
       // numList.stream().collect(Collectors.)
    }

//    public static void main(String[] args) {
//        ArrayList<String>list=new ArrayList<>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//
//        String test="myName";
//        StringBuilder sb=new StringBuilder(test);
//        String ch=Character.toString(test.charAt(0)).toUpperCase();
//        sb.setCharAt(0,ch.charAt(0));
//        System.out.println(sb.toString());
//
//        String s= list.stream().collect(Collectors.joining("','","'","'"));
//
////        List<Object> nls=new ArrayList<>();
////        buildRecordList(list,nls,0);
//        System.out.println(s);
//       // filterBasedOnMachingOp();
//       // operationOnStreamData();
//       // numericalOp();
//       // flatMap();
//      //  generate();
//      //  iterationOp();
//       // collectorsOp();
//      //  mapping();
//       // toMap();
//       // groupByOp();
//       // partitionByOp();
//      //  reduceOp();
//       // sorted();
//     //   toMap();
//        //map();
//        collectOperation();
//    }

    private static  void collectOperation(){
        String result = getPersons().parallelStream().collect(StringBuilder::new,
                (response, element) -> response.append(" ").append(element.name),
                (response1, response2) -> response1.append(",").append(response2.toString()))
                .toString();
        System.out.println("Result: "  + result);
    }
    private static void operationWithFilter(){
        Person p=getPersons().stream().filter(s->s.getAge()>30).findFirst().orElse(null);
        System.out.println(p.getName());
        Person p1=getPersons().stream().filter(s->s.getAge()>30).findAny().get();
    }
    private static void map(){
        getPersons().stream().map(p->p.getName()).collect(Collectors.toList()).forEach(x->System.out.println(x));
       Integer age= getPersons().stream().mapToInt(p->p.getAge()).sum();
       System.out.println(age);


    }
    private static void distinct(){
        getPersons().stream().filter(distinctByKey(s->s.getName())).distinct().count();
       // 3. Distinct by Property

    }

    private static void sorted(){
        getPersons().stream().sorted(Comparator.comparing(Person::getName)).forEachOrdered(s->System.out.println(s.name));
        Map<String,String> map=new HashMap<>();
        map.put("1","kk");
        map.put("2","LP");
        map.put("5","RF");
        map.put("3","SN");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEachOrdered(s->System.out.println(s.getValue()));

    }
static <T>Predicate <T>  distinctByKey(Function<? super T,?> keyExtractor){
        Map<Object,Boolean>seen=new ConcurrentHashMap<Object,Boolean>();
        return t->seen.putIfAbsent(keyExtractor.apply(t),Boolean.TRUE)==null;

}
    private static void concat(){
      //  static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)

    }

    private static void directoryAcc() throws IOException {
        Path dir = Paths.get("C:/page");
        DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir, "*.{txt,jpg}");

        dirStream.forEach(f -> System.out.println(f.getFileName()));
    }
    private  static void groupByOp(){
//<T,K> Collector<T,?,Map<K,List<T>>> groupingBy(Function<? super T,? extends K> classifier)
        getPersons().stream().collect(Collectors.groupingBy(Person::getAge)).forEach((k,v)->System.out.println(k+":"+((Person)v.get(0)).getName()));
    }

    private  static void partitionByOp(){
//public static <T> Collector<T,?,Map<Boolean,List<T>>>
//                                         partitioningBy(Predicate<? super T> predicate)
        getPersons().stream().collect(Collectors.partitioningBy(p->p.age>25)).forEach((k,v)->System.out.println(k+""+v.get(0)));
    }


    private  static void reduceOp(){
//public static <T> Collector<T,?,Optional<T>> reducing(BinaryOperator<T> op)
        getPersons().stream().collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))).ifPresent(s->System.out.println(s));

        Comparator<Person> ageComparator = Comparator.comparing(Person::getAge);
        Map<String, Optional<Person>> eldestByClass = getPersons().stream().collect(Collectors.groupingBy(Person::getName,
                Collectors.reducing(BinaryOperator.maxBy(ageComparator))));
        eldestByClass.forEach((k,v)->System.out.println("Class:"+k+" Age:"+
                ((Optional<Person>)v).get().getAge()+" Name:"+((Optional<Person>)v).get().getName()));
    }


    private  static void collectorsOp(){

        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
     int data= list.stream().collect(Collectors.averagingInt(a->a*2)).intValue();
     System.out.println(data);
        int update=list.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(a->a*2),s->s*s)).intValue();
        System.out.println(update);



    }

    private  static void filterMapOp(){
    //<R> Stream<R> map(Function<? super T,? extends R> mapper)

       // List<String> ;
    }
    private  static void filterBasedOnMachingOp(){
        //    allMatch, anyMatch and noneMatch
    //pass predicate as argument
        List<String> list=new ArrayList<>();

        list.add("kk");
        list.add("Sk");

        list.add("Singh");
        list.add("kk");

        list.add("Mk");
        Boolean s=list.stream().anyMatch(a->a.equals("kk"));
        Boolean s1=list.stream().allMatch(a->a.equals("kk"));

        Boolean s2=list.stream().noneMatch(a->a.equals("kk"));
        System.out.println("ANy: "+s+" All:"+s1+"  None:"+s2);



    }

    private  static void operationOnStreamData(){
        //concat, count, sorted and distinct

        List<Integer> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        list.add(10);
        list.add(20);

        list.add(30);
        list.add(10);

        list.add(15);
        list1.add(40);

       Long count= list.stream().count();
       System.out.println(count+"");
       list.stream().sorted().forEach(s->System.out.println(s));
        Long distinct=list.stream().distinct().count();
        System.out.println(distinct+"");

        Stream.concat(list.stream(),list1.stream()).forEach(s->System.out.println(s));
    }


    private  static void numericalOp(){
        //    findAny, findFirst, max and min methods return Optional instance and limit method returns stream instance.

        List<Integer> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        list.add(10);
        list.add(20);

        list.add(30);
        list.add(10);

        list.add(15);
        list1.add(40);

        list.stream().findAny().ifPresent(s->System.out.println("Any:"+s));;
        list.stream().findFirst().ifPresent(s->System.out.println("Find First:"+s));
        list.stream().max(Integer::compareTo).ifPresent(s->System.out.println("max:"+s));
        list.stream().min(Integer::compareTo).ifPresent(s->System.out.println("Min:"+s));
        list.stream().limit(3).forEach(s->System.out.println(s));



    }

    private  static  void flatMap(){
        List<Integer> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        list.add(10);
        list.add(20);

        list.add(30);
        list.add(10);

        list.add(15);
        list1.add(40);
        Stream stream=Stream.of(list,list1).flatMap(s->s.stream());
        stream.forEach(s->System.out.println(s));
    }

    private  static  void generate(){
        Stream.generate(()->1).forEach(s->System.out.println(s));
    }

    private static  void iterationOp(){
//forEach() method accepts Consumer as an argument and that
// consumer is applied to each element of the stream. For example we can create
// a consumer to print the stream element and use it with forEach() method. forEachOrdered()
// method does the same thing but in the encounter order of the stream.
       // forEach, forEachOrdered, peek, skip and toArray
        Stream stream =Stream.of("S","A","D","1");
        stream.forEachOrdered(s->System.out.println(s));
        //peek() is an intermediate operation. It returns a new stream which
        // consists all the elements of stream after applying the Consumer.
        Stream.of("S","A","D","1").peek(s->System.out.println(s+",")).collect(Collectors.toList());
        Stream.of("S","A","D","1").skip(2).forEachOrdered(s->System.out.println(s+"-S")
        );

    }

    private static  void mapping(){
        //mapping(Function<? super T,? extends U> mapper, Collector<? super U,A,R> downstream)


       getPersons().stream().collect(Collectors.
               groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.joining(",")))).forEach((k,v)->System.out.println(k+":"+v));


    }

    private static void toMap(){
        getPersons().stream().collect(Collectors.toMap(Person::getName,Person::getAge)).forEach((k,v)->System.out.println(k+":"+v));

        getPersons().stream().collect(Collectors.toMap(Person::getAge,Person::getName,(k,v)->k+","+v)).forEach((k,v)->System.out.println(k+":"+v));

        getPersons().stream().collect(Collectors.toMap(Person::getAge,Person::getName,(k,v)->k+","+v,LinkedHashMap::new)).forEach((k,v)->System.out.println(k+":"+v));



    }


    private static List<Person> getPersons(){
        List<Person>list=new ArrayList<>();
        list.add(new Person("kksingh",31));
        list.add(new Person("Ninu",23));

        list.add(new Person("Nano",90));

        list.add(new Person("Raw",31));
        list.add(new Person("plsingh",22));
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
        public static List<Person> getList() {
            List<Person> list = new ArrayList<>();
            list.add(new Person("Ram", 30));
            list.add(new Person("Shyam", 20));
            list.add(new Person("Shiv", 20));
            list.add(new Person("Mahesh", 30));
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
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return getAge() == person.getAge() &&
                    Objects.equals(getName(), person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getAge());
        }
    }
}
