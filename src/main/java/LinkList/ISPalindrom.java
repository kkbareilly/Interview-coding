package LinkList;

public class ISPalindrom {


    public boolean isPalindron(Node node){
        if(node==null)
            return true;
        if(node.next==null)
            return true;
        Node head=node;
        boolean ispalindrom=true;
        Node middle=getMiddleElement(node);
        middle.next=reverse(middle.next);
        Node secondHalf=middle.next;
        Node second=secondHalf;
        middle.next=null;
        while (head!=null&& second!=null){
            if(head.data!=second.data)
                ispalindrom=false;
            head=head.next;
            second=second.next;
        }
        middle.next=reverse(secondHalf);
        return ispalindrom;
    }

    public Node getMiddleElement(Node node){
        if(node==null)
            return node;
        Node slow=node;
        Node fast=node;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private Node reverse(Node node){
        if(node==null)
            return node;
        Node next=node;
        Node current=next;
        Node prev=null;
        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
         return prev;
    }
}
