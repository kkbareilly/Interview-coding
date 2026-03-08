package LRU;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class LRU {
    Map<Integer,Node> map;
    int capacity;

    Node head;
    Node end;
   ReentrantLock reentrantLock;
    public LRU(int capacity){
        this.capacity=capacity;
        reentrantLock=new ReentrantLock();
        map=new ConcurrentHashMap<Integer,Node>(capacity);
    }
    public static void main(String[] args) {
        LRU cache = new LRU(4);
        cache.set(1,4);
        cache.set(2,5);
        cache.set(3,6);
        cache.set(7,8);
        cache.set(8,4);
        cache.set(5,8);
        cache.set(12,56);
        cache.set(43,1231);
        cache.set(78,123);
        cache.map.forEach((k,v)->{
            System.out.println("Key="+k+"  value="+v.value);
        });

    }


    public int getNode(int value){
        try {
            reentrantLock.lock();
            if (map.containsKey(value)) {
                Node data = map.get(value);
                remove(data);
                setHead(data);
                return data.value;
            }
            return -1;
        }finally {
            reentrantLock.unlock();
        }
    }

    public void set(int key,int value){
        try {
            reentrantLock.lock();
        if(map.containsKey(key)){
            Node data=map.get(key);
            data.value=value;
            remove(data);
            setHead(data);

        }else{
            Node created=new Node(key,value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
            }else
                setHead(created);
            map.put(key,created);
        }
        }finally {
            reentrantLock.unlock();
        }
    }
    public void remove(Node node){

        if(node !=null && node.prev!=null){
            node.prev.next=node.next;
        }else if(node !=null){
            head=node.next;
        }
        if(node !=null && node.next!=null){
            node.next.prev=node.prev;
        }else{
            end=node.prev;
        }
    }
    public void setHead(Node node){
        node.next=head;
        node.prev=null;
        if(head!=null){
            head.prev=node;
        }
        if(head==null){
            end=node;
        }
        head=node;

    }

}
