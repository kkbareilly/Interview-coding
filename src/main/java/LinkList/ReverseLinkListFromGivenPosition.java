package LinkList;

public class ReverseLinkListFromGivenPosition {




    public Node reverse(Node node,int p,int q){

        Node prev=null;
        Node head=node;
        for(int i=0; node!=null && i<p;i++){
            prev=node;
            node=node.next;
        }
        Node lastNodeOfFirstHalf=prev;
        Node firstNodeOfSecondHalf=node;
                Node next=null;
                for(int i=0;i<q-p;i++){
                    next=node.next;
                    node.next=prev;
                    prev=node;
                    node=next;
                }
              lastNodeOfFirstHalf.next=prev;
                firstNodeOfSecondHalf.next=node;
               return head;
    }
}
