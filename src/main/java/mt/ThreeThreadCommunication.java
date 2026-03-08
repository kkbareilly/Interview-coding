package mt;

public class ThreeThreadCommunication {

    public static void main(String[] args) {
        ThreeThreadCommunication obj=new ThreeThreadCommunication();
        NumberPrinter runnable1=new NumberPrinter(obj,0,"Xactly");
        NumberPrinter runnable2=new NumberPrinter(obj,1,"Corp");
        NumberPrinter runnable3=new NumberPrinter(obj,2,"India");

        Thread t1=new Thread(runnable1,"T1");
        Thread t2=new Thread(runnable2,"T2");
        Thread t3=new Thread(runnable3,"T3");

        t1.start();
        t3.start();
        t2.start();

    }
}

class NumberPrinter implements Runnable{
    ThreeThreadCommunication obj;
    int threadNumber;
    static  int number=0;
    String message;
    NumberPrinter(ThreeThreadCommunication obj,int threadNumber,String message){
        this.obj=obj;
        this.threadNumber=threadNumber;
        this.message=message;
    }

    public void run() {

        while (true){
            synchronized (obj){

                while (number%3!=threadNumber ){
                    try {
                        Thread.sleep(200);
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                number++;
                System.out.println(Thread.currentThread().getName() + " " + number+"  Message "+message);
                obj.notifyAll();
            }
        }
    }
}