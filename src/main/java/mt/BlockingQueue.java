package mt;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue que;

    private  int limit =10;

    BlockingQueue(int limit){
        this.limit=limit;
        que=new LinkedList();
    }

    private synchronized void enqueue(int data) throws InterruptedException {
        while (limit==this.que.size()){
            wait();
        }
        que.add(data);
        notify();
    }

    private synchronized boolean deque() throws InterruptedException {
        while (this.que.size()==0){
            wait();
        }
        notify();
        return this.que.remove(0);
    }
}
