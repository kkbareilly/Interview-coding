package java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStreamOp {
//    public static void main(String[] args) {
//      //  final  int b=3;
//
//      //  Properties p=System.getProperties();
//      //  System.out.println(p.getProperty("args"));
////     System.out.println( Employee.getEmpList().stream().noneMatch(emp->emp.name.equalsIgnoreCase("Z")));  ;
////        System.out.println( Employee.getEmpList().stream().anyMatch(emp->emp.name.equalsIgnoreCase("A")));  ;
////        System.out.println( Employee.getEmpList().stream().allMatch(emp->emp.name.equalsIgnoreCase("A")));  ;
////       // Employee.getEmpList().stream().collect(Co)
//      //  ops();
//
////        class inner{
////            final  int a=3;
////            inner(){
////                System.out.println("s");
////            }
////        }
//
//    }
public static void main(String[] args) {

     String s= "bbrrg";
   int ans = 0;
   int n = s.length();
    int A[]=new int[n];
    int x;
for(int i=1;i<=n;i++) {
    A[i] = A[i - 1] ^ (1 << (s.charAt(i-1) - 97));
}
//    for(int i=1;i<=n;i++) {
//        for(int j=1;j<=n;j++) {
//            x=A[j]^A[i-1];
//            if (x&(x-1)) == )    //if x is a power of 2 or not
//            ans++;
//        }
//    }

    System.out.println( countOptions(8,4));

}

    public static long countOptions(int people, int groups) {
        // Write your code here
        int t[][]=new int[people+1][groups+1];
        int i=0, j=0;
        while(i<people){
            if(i==0 || j==0){
                t[i][j]=0;
            }
        }
        for(int ppl=1;i<people;i++){
            for(int grp=1;j<Math.min(i, groups);j++){
                t[ppl][grp]=t[ppl-grp][grp]+t[ppl-1][grp-1];
            }
        }

        return t[people][groups];
    }
    private static void ops(){
        List<Employee> emp=Employee.getEmpList();
      Object[] emps= emp.stream().toArray();
      System.out.println(((Employee)emps[0]).name);
      emp.stream().sorted(Comparator.comparing(Employee::getName)).forEach(e->System.out.println(e.name));
      emp.stream().skip(2).forEach(e->System.out.println(e.getId()));
       int arr[]={1,2,3,4,5};
       int sum= Arrays.stream(arr).reduce(0,(x,y)->x+y);
       System.out.println(sum);
        System.out.println( emp.stream().max(Comparator.comparing(Employee::getSal)).get().name);
System.out.println("----------");
        Stream.iterate(1,n->n*2).limit(6).forEach(e->System.out.println(e));
        Stream.generate("kksingh"::toString).limit(5).forEach(e->System.out.println(e));

        List<Integer> list2 = Arrays.asList(5, 6, 7);
        int res = list2.parallelStream().reduce(1, (s1, s2) -> s1 * s2, (p, q) -> p + q);
System.out.println(res);
        toMap();
    }

    public static void Collectionops(){
      List<Employee>emp=  Employee.getEmpList();
      emp.stream().collect(StringBuilder::new,(response,element)->response.append(" ").append(element),(response1,response2)->response1.append(",").append(response2.toString())).toString();
    }

    public static void toMap(){
        List<Employee>emp=  Employee.getEmpList();
     LinkedHashMap map=   emp.stream().collect(Collectors.toMap(Employee::getId,Employee::getName,(x,y)->x+","+y, LinkedHashMap::new));
    map.forEach((p,q)->System.out.println("key="+p+" Value"+q));
    }

    public static void joining(){
        List<Integer> list2 = Arrays.asList(5, 6, 7);

        List<String> list = Arrays.asList("Ram","Shyam","Shiv","Mahesh");
        String result=  list.stream().collect(Collectors.joining());
        System.out.println(result);
        result=  list.stream().collect(Collectors.joining(","));
        System.out.println(result);
        result=  list.stream().collect(Collectors.joining("-","[","]"));
        System.out.println(result);
    }

}


 class Employee {
    public int id;
    public String name;
    public int sal;
    public Employee(int id,String name,int sal  ){
        this.id = id;
        this.name = name;
        this.sal = sal;
    }
    public static List<Employee> getEmpList(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "A", 2000));
        list.add(new Employee(2, "B", 3000));
        list.add(new Employee(3, "C", 4000));
        list.add(new Employee(4, "D", 5000));
        return list;
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

     public int getSal() {
         return sal;
     }

     public void setSal(int sal) {
         this.sal = sal;
     }
 }