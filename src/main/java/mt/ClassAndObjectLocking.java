package mt;

public class ClassAndObjectLocking {
    public static void main(String[] args) {
        Shared s1=new Shared();
        Shared s2=new Shared();
        Thread1 t1=new Thread1(s2);
        Thread2 t2=new Thread2(s2);
        t1.start();
        t2.start();
    }


}

class Thread1 extends Thread{

    Shared s;
    Thread1(Shared s1){
        this.s=s1;
    }
    public  void run(){
       // System.out.println(Thread.currentThread()+" Thread1");

        s.test7();


    }
}

class Thread2 extends Thread{

    Shared s;
    Thread2(Shared s1){
        this.s=s1;
    }
    public  void run(){
        s.test8();

    }
}

class Shared{

    public void test1(){

        Thread th=Thread.currentThread();
        for(int i=0;i<5;i++) {
            System.out.println("test1="+th.getName());
        }
    }

    public void test2(){

        Thread th=Thread.currentThread();
        for(int i=0;i<5;i++) {
            System.out.println("test2="+th.getName());
        }
    }

    public static  void test3(){

        Thread th=Thread.currentThread();
        for(int i=0;i<5;i++) {
            System.out.println("test3="+th.getName());
        }
    }

    public static void test4(){

        Thread th=Thread.currentThread();
        for(int i=0;i<15;i++) {
            System.out.println("test4="+th.getName());
        }
    }

    public synchronized void test5(){

        Thread th=Thread.currentThread();
        for(int i=0;i<15;i++) {
            System.out.println("test5="+th.getName());
        }
    }

    public synchronized void test6(){

        Thread th=Thread.currentThread();
        for(int i=0;i<15;i++) {
            System.out.println("test6="+th.getName());
        }
    }


    public static synchronized void test7(){

        Thread th=Thread.currentThread();
        for(int i=0;i<15;i++) {
            System.out.println("test7="+th.getName());
        }
    }

    public static synchronized void test8(){

        Thread th=Thread.currentThread();
        for(int i=0;i<15;i++) {
            System.out.println("test8="+th.getName());
        }
    }

}