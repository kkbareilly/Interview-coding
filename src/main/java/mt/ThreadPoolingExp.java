package mt;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ThreadPoolingExp {
    public static void main(String[] args) {
//        ExecutorService executorService= Executors.newFixedThreadPool(getNumberOfProcessor());
//    executorService.execute(new Task());
//       System.out.println("Number Of Processors "+getNumberOfProcessor()); ;
//    executorService.shutdown();
       // joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)

        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String s=list.stream().collect(Collectors.joining("','","('","')"));
        System.out.println(s);

    }

    public static int getNumberOfProcessor(){
       int n= Runtime.getRuntime().availableProcessors();
     Long memory= Runtime.getRuntime().maxMemory();
     Long freeMemory=Runtime.getRuntime().freeMemory();
     Long totalMemory=Runtime.getRuntime().totalMemory();

     System.out.println("Max Memory:"+memory+"\n  Total Memory :"+totalMemory+"\n Free Memory  "+freeMemory);

     return n;

    }

    private static  ExecutorService getCachedThreadPool(){
        //it will use internally synchronised que so will store only one task at a time
        return Executors.newCachedThreadPool();
    }

    private static ScheduledExecutorService getScheduledThreadPool(){
        //it will use internally Delay que so will store task based on schedule time
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(10);
        //task to run after 10 sec delay
        executorService.schedule(new Task(),10 , TimeUnit.SECONDS);
        //run after every 10 sec doesn't care if previous task get completed or not(repeatedly  )
        executorService.scheduleAtFixedRate(new Task(),15,10,TimeUnit.SECONDS);
        //run after every 10 sec after completion of previous task.

        executorService.scheduleWithFixedDelay(new Task(),15,10,TimeUnit.SECONDS);
        return executorService;

    }
}

class  Task implements Runnable{

    @Override
    public void run() {
     System.out.println("test");
    }
}
