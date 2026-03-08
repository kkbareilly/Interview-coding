package LinkList;

public class MergeTwoSrtledLinkedList {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        // 1.3.5 LinkedList created

        Node head2 = new Node(0);
        head2.next = new Node(2);
        head2.next.next = new Node(4);
  Node n= mergeReq(head1,head2);
  // Node n= merge(head1,head2);

        while (n!=null){
       System.out.println(n.data);
       n=n.next;
   }
    }

    public static Node merge(Node h1,Node h2){
        // if only one node in first list
        // simply point its head to second list
        if (h1.next == null) {
            h1.next = h2;
            return h1;
        }

        // Initialize current and next pointers of
        // both lists
        Node curr1 = h1, next1 = h1.next;
        Node curr2 = h2, next2 = h2.next;

        while (next1 != null && curr2 != null) {
            // if curr2 lies in between curr1 and next1
            // then do curr1->curr2->next1
            if ((curr2.data) >= (curr1.data) && (curr2.data) <= (next1.data)) {
                next2 = curr2.next;
                curr1.next = curr2;
                curr2.next = next1;

                // now let curr1 and curr2 to point
                // to their immediate next pointers
                curr1 = curr2;
                curr2 = next2;
            }
            else {
                // if more nodes in first list
                if (next1.next != null) {
                    next1 = next1.next;
                    curr1 = curr1.next;
                }

                // else point the last node of first list
                // to the remaining nodes of second list
                else {
                    next1.next = curr2;
                    return h1;
                }
            }
        }
        return h1;
    }

    public static Node mergeReq(Node h1,Node h2){
        if(h1==null)
            return h2;
        if(h2==null)
            return h1;
        if(h1.data<h2.data){
            h1.next=mergeReq(h1.next,h2);
            return h1;
        }else{
            h2.next=mergeReq(h1,h2.next);
            return h2;
        }
    }
}
