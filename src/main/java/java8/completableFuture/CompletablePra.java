package java8.completableFuture;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletablePra {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       // CompletionStage<Void> acceptEither(CompletionStage<? extends T> other, Consumer<? super T> action)
       // <U> CompletionStage<U> applyToEither(CompletionStage<? extends T> other, Function<? super T,U> fn)
       // <U> CompletionStage<U> thenApply(Function<? super T,? extends U> fn)
        //1. supplyAsync(Supplier<U> supplier)
        //2. supplyAsync(Supplier<U> supplier, Executor executor)
        thenApply();
    }
    private  static void applyEither() throws ExecutionException, InterruptedException {

        CompletableFuture<Person>future1=CompletableFuture.supplyAsync(()->new Person("1","singh"));
        CompletableFuture<Person>future2=CompletableFuture.supplyAsync(()->new Person("2","pk"));

        CompletableFuture<String> ft=future1.applyToEither(future2,p->p.getName());


        CompletableFuture<Person>future3=CompletableFuture.completedFuture(new Person("1","try"));
        CompletableFuture<Person>future4=CompletableFuture.completedFuture(new Person("2","pk"));

        CompletableFuture<String> ft1=future3.applyToEither(future4,p->p.getName());

        System.out.println(ft.get());
        System.out.println(ft1.get());


    }

    private  static void acceptEither() throws ExecutionException, InterruptedException {


        CompletableFuture<Person>future1=CompletableFuture.supplyAsync(()->new Person("1","singh"));
        CompletableFuture<Person>future2=CompletableFuture.supplyAsync(()->new Person("2","pk"));

        CompletableFuture<Void> ft=future1.acceptEither(future2,s-> System.out.println(s.getName()));


        CompletableFuture<Person>future3=CompletableFuture.completedFuture(new Person("1","try"));
        CompletableFuture<Person>future4=CompletableFuture.completedFuture(new Person("2","pk"));

        CompletableFuture<Void> ft1=future3.acceptEither(future4, s-> System.out.println(s.getName()));

ft1.join();
System.out.println("completed");

    }

    private static void thenApply() throws ExecutionException, InterruptedException {

        CompletableFuture future=CompletableFuture.supplyAsync(()->10).thenApply(data->data+200);
        System.out.println(future.get());
        List<Integer> list= Arrays.asList(12,110,20,30);
        list.stream().map(data->CompletableFuture.supplyAsync(()->data*data)).map(cfuture->cfuture.thenApply(res->"Squire"+res)).forEach(s -> {
            try {
                System.out.println(s.get());

               String title= CompletableFuture.supplyAsync(()->"kk").thenApply(data->data+" Singh").get();
               System.out.println(title);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }


    public static void supplyAsynch(){
        //1. supplyAsync(Supplier<U> supplier)
        //2. supplyAsync(Supplier<U> supplier, Executor executor)
        CompletableFuture future=CompletableFuture.supplyAsync(()->"Test");
        ExecutorService service= Executors.newFixedThreadPool(2);
        CompletableFuture future1=CompletableFuture.supplyAsync(()->"hello",service);

        CompletableFuture.supplyAsync(()->"hello").whenComplete((data,error)->{
            if(error!=null){}
            System.out.println(error);
            System.out.println(data);
        });
    }
}

class Person{
    private String id;
    private String name;
    Person(){

    }
    Person(String id,  String name){
this.id=id;
this.name=name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
