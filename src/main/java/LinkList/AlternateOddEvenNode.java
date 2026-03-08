package LinkList;

public class AlternateOddEvenNode {

    public Node Alternate(Node node){

        if(node==null || node.next==null)
            return node;
        Node oddHead=new Node();
         Node odd=oddHead;
        Node evenHead=new Node();
        Node even=evenHead;

        while (node!=null){
            if(node.data%2==0){
                even.next=node;
            }else {
                odd.next=node;
            }
            node=node.next;
        }
         odd.next=null;
        even.next=null;
        odd=oddHead.next;
        even=evenHead.next;
        Node head=new Node();
        Node temp=head;
        while (odd!=null && even!=null){
            if(odd!=null){
                temp.next=odd;
                temp=temp.next;
                odd=odd.next;
            }
            if(even!=null) {
                temp.next=even;
                temp=temp.next;
                even=even.next;
            }
        }
      temp.next=odd!=null?odd:even;
        return head.next;
    }
}
