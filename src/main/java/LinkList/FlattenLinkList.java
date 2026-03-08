package LinkList;

public class FlattenLinkList {

Node prev;
public Node flatten(Node node){
        if(node==null)
            return node;
         prev=node;
         Node next=node.next;
        if(node.down!=null){
            node.next=flatten(node.down);
        }
        if(next!=null){
            prev.next=flatten(next);
        }
        return node;
}

public  Node flattenSorted(Node node){
    if(node==null)
        return node;
    return merge(node,flattenSorted(node.right));

}
    public  Node merge(Node a,Node b){

        Node temp=new Node();
        Node head=temp;
        while (a!=null && b!=null){
              if(a.data<b.data){
                  temp.next=a;
                  a=a.next;
              }else{
                  temp.next=b;
                  b=b.next;
              }
              temp=temp.next;
        }
        temp.next=(a==null)?b:a;
        head.next.right=null;
        return head.next;
    }
    class  Node{
        Node right;
        Node next;
        Node down;
        int data;
    }
}

