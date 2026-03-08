package LinkList;

public class FlattenInDepth {
Node prev;
    public Node flattenEasy(Node node){
        if(node==null)
            return node;
        prev=node;
        Node next=node.next;
        if(next.down!=null)
            node.next=flattenEasy(node.down);
        if(next!=null)
            prev.next=flattenEasy(next);
        return node;
    }


    class Node{
        Node down;
        Node next;
    }
}

