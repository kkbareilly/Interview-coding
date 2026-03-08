package LRU;

public class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key=key;
        this.value=value;
        next=null;
        prev=null;
    }

    public Node(Integer integer, Object o) {
    }
}
