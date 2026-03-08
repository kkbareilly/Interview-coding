package LinkList;

public class SubstractionOfTwoNumber {

public  Node subtractTwoNumber(Node n1,Node n2){
    Node head1=n1;
    Node head2=n2;
    int count_1=0;
    int count_2=0;
    while (n1!=null){
        n1=n1.next;
        count_1++;

    }
    while (n2!=null){
        n2=n2.next;
        count_2++;
    }
    n1=head1;
    n2=head2;
    if(count_1<count_2 ||(count_1==count_2 && n2==getMinimum(n1,n2))){
        Node t=n1;
        n1=n2;
        n2=t;
    }
    n1=reverse(n1);
    n2=reverse(n2);
    return subtract(n1,n2);
}
public Node getMinimum(Node node1,Node node2){
    Node head1=node1;
    Node head2=node2;
    while (node1!=null){
        if(node1.data>node2.data)
            return head1;
        else if(node1.data<node2.data)
              return head2;
        node1=node1.next;
        node2=node2.next;
    }
    return head1;
}

    public Node subtract(Node n1,Node n2){
        if(n1==null)
            return n2;
        if(n2==null)
            return n1;
        Node prev=null;
        Node head=null;
        boolean isBorrow=false;
        while (n1!=null || n2!=null){
            if(isBorrow){
                n1.data=n1.data-1;
                isBorrow=false;
            }
            if(n1!=null && n2!=null && n1.data<n2.data){
                n1.data=n1.data+10;
                isBorrow=true;
            }
            int diff=(n1!=null?n1.data:0)-(n2!=null?n2.data:0);
            Node node=new Node(diff);
            if(head==null){
                head=node;
            }else{
                prev.next=node;
            }
            prev=node;
            if(n1!=null){
                n1=n1.next;
            }
            if(n2!=null){
                n2=n2.next;
            }
            head=reverse(head);
        }
        return head;
    }

    public Node reverse(Node n){
        if(n==null)
            return  n;
        Node pre=null;
        Node next;
        Node cur=n;
        while (cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;

        }
        return pre;
    }
}
