package LinkList;

public class ReverseBlockOfKNodes {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        // 1.3.5 LinkedList created

        Node head2 = new Node(0);
        head1.next.next.next = new Node(2);
        head1.next.next.next.next = new Node(4);
        // Node n= mergeReq(head1,head2);
        Node n= reversK(head1,2);

        while (n!=null){
            System.out.println(n.data);
            n=n.next;
        }
    }
    public static Node reversK(Node root,int k){

        Node current=root;
        Node next=null;
        Node prev=null;
        int count=k;
        while (count>0 && current!= null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            count--;
        }
        if (next!=null)
        root.next=reversK(next,k);
        return prev;
    }
}
