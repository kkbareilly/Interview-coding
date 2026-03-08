package mt;

public class PrintEvenOddUsingTwoThread {
    int a[]={1,2,3,4,5,6,7,8,9};
    int n=10;
    static int number=1;
    public static void main(String[] args) {
        PrintEvenOddUsingTwoThread po=new PrintEvenOddUsingTwoThread();
        Thread thread1=new Thread(new Runnable(){
            public void run() {
            po.printOdd();
            }
        },"t1");
        Thread thread2=new Thread(new Runnable(){
            public void run() {
            po.printEven();
            }
        },"t2");
        thread1.start();
        thread2.start();
    }

    public void printEven(){
        synchronized (this) {
            while (number < n) {
                if (number % 2 != 0) {
                    try {
                        wait();
                    } catch (Exception e) {

                    }

                }
                System.out.println(Thread.currentThread().getName() + "  " + number);
                number++;
                notify();

            }
        }
    }
    public void printOdd(){
       synchronized (this){
        while (number<n){
            if(number%2==0){
                try {
                    wait();
                }catch (Exception e){

                }

            }
            System.out.println(Thread.currentThread().getName()+"  "+number);
            number++;
            notify();
        }
    }}
}
