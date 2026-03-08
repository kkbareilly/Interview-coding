package java8.completableFuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
       CompletableFutureTest t=new CompletableFutureTest();
       t.processResult();
    }

    public void processResult() throws ExecutionException, InterruptedException {
        CompletableFuture<Employee> future1=CompletableFuture.completedFuture(new Employee(2,"ksingh",34));
        CompletableFuture<Employee> future2=CompletableFuture.completedFuture(new Employee(3,"reingo",32));
        CompletableFuture sup=CompletableFuture.supplyAsync(()->{
            return "Test Executed";
        });
        CompletableFuture sup1=CompletableFuture.supplyAsync(()->{
            return "Test failed";
        });

       CompletableFuture fun= future1.applyToEither(future2,e->{
            System.out.println(e.name);
            return e.name;
        });
        System.out.println(fun.join());


   CompletableFuture fut= future1.acceptEither(
        future2,
        p -> {
          System.out.println(p.name);
        });
   System.out.println(fut.join());

  CompletableFuture future= sup.applyToEither(sup1,e->{return e;});
    System.out.println(future.join());
        System.out.println(future.get());


        //Then Apply feature

    CompletableFuture thenApp=    sup.applyToEither(sup1,s->{return s;}).thenApply(p->{return p+" finally accepted";});
 System.out.println(thenApp.join());


        //SuppyAsync with Executer Service

        ExecutorService service= Executors.newFixedThreadPool(2);
        CompletableFuture fut1=CompletableFuture.supplyAsync(()->{
                    try {
                        return getData();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },
                service
        ).thenApply(p->{
            try {
                return p+"--"+getDataForAppend();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(fut1.join());
        service.shutdown();
    }




 public String getDataForAppend() throws InterruptedException {

       // Thread.sleep(1000);
    System.out.println(Thread.currentThread().getName());
        return "append";
 }
    public String getData() throws InterruptedException {

       // Thread.sleep(100);
        System.out.println(Thread.currentThread().getName());

        return "Kruck";
    }
    public List<Employee>getEmployee(){
        Employee e1=new Employee(1,"kk",34);
        Employee e2=new Employee(2,"reco",32);
        Employee e3=new Employee(2,"tri",30);
        List<Employee>ls=new ArrayList<Employee>(Arrays.asList(e1,e2,e3));
      return ls;

    }

    class Employee{
        public int id;
        public String name;
        public int age;
        Employee(int id,String name,int age){
            this.id=id;
            this.name=name;
            this.age=age;
        }
    }
}
