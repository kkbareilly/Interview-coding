package LinkList;

import java.util.List;

public class AddisionTwoNumber {

    public static void main(String[] args) {
        Node n1=new Node(10);
        n1.next=new Node(8);
        n1.next.next=new Node(14);

        Node n2=new Node(23);
        n2.next=new Node(18);
        n2.next.next=new Node(14);

        Node l1=Reverse.iterative(n1);
        Node l2=Reverse.iterative(n2);
        Node n=add(l1,l2);
        Node revered=Reverse.iterative(n);
        while (revered!=null){
            System.out.println(revered.data);
            revered=revered.next;
        }

    }

    public static Node add(Node l1, Node l2){

        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        Node current=new Node(0);
        Node head=current;
        int sum=0;
        int advance=0;

        while (l1!=null && l2!=null){
            sum=l1.data+l2.data+advance;
            advance=sum/10;
            sum=sum%10;
            current.next=new Node(sum);
            current=current.next;
            l1=l1.next;
            l2=l2.next;
        }
        if (l1!=null){
            if(advance!=0){
                current.next=add(l1.next,new Node(advance));
            }else
                current.next=l1;
        }

       else if (l2!=null){
            if(advance!=0){
                current.next=add(l2.next,new Node(advance));
            }else
                current.next=l2;
        }

       else if(advance!=0)
            current.next=new Node(advance);

        return head.next;

    }

    public Node iterative(Node n1,Node n2){
        if(n1==null )
            return n2;
        if(n2==null)
            return  n1;
        Node pre=null;
        Node head=null;
        Node current=null;
        int sum=0,c=0;
        while (n1!=null && n2!=null){
            sum=c+n1.data+n2.data;
            c=sum/10;
            sum=sum%10;
           Node node= new Node(sum);
            if(head==null){
                head=node;
            }else{
                pre.next=node;
            }
            pre=node;
            if(n1!=null)
                n1= n1.next;
            if(n2!=null)
                n2= n2.next;
            if(c!=0)
                pre.next=new Node(c);
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
