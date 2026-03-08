package java8.stream;

import java.util.ArrayList;
import java.util.List;

public class FunctionsOp {
    //allMatches()
    //anyMatches()
    //nonMatches()

    public static void main(String[] args) {
       matchOps();
    }


    public static void  matchOps(){
     List<Employee>data=  Employee.getEmpList();
           boolean all=  data.stream().allMatch(e->e.id<100);
           boolean any=  data.stream().anyMatch(e->e.id<100);
           boolean non=  data.stream().noneMatch(e->e.id<100);
        System.out.println(all+""+any+"   "+non );

    }



}