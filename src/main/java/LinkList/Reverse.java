package LinkList;

public class Reverse {

    public static void main(String[] args){
        Node root=new Node();
        root.setData(4);
        Reverse r=new Reverse();

        Node head= r.insertAtBeginning(root,5);
        head= r.insertAtBeginning(head,9);
        head= r.insertAtBeginning(head,7);
        head= r.insertAtBeginning(head,6);
    r.print(head);
    System.out.println("==========");


    }

    private  Node insertAtBeginning(Node root,int data){

        if(root!=null){

            Node n=new Node(data);
            n.next=root;
            root=n;
        }

        return root;
    }

    private void print(Node n){
        while (n!=null){
            System.out.println(n.data);
            n=n.next;
        }
    }
    public static Node iterative(Node head){

        if(head==null)
            return null;
        else{
            Node current=head;

            Node next=null;
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

    private static Node recursive(Node node){

        if(node ==null || node.next==null)
            return node;
       Node temp=recursive(node.next);
        node.next.next=node;
        node.next=null;
        return temp;
    }
}
