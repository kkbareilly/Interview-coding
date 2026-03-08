package LinkList;

public class RoateRightByK {

public static void main(String[] args){
    Node root=new Node();
    root.setData(4);
    RoateRightByK r=new RoateRightByK();

   Node head= r.insertAtBeginning(root,5);
    head= r.insertAtBeginning(head,9);
    head= r.insertAtBeginning(head,7);
    head= r.insertAtBeginning(head,6);
    r.print(head);
    System.out.println("=========");
    head=r.rorateClockWise(4,head);
    r.print(head);

    System.out.println("=========");
    head=r.rotateAntiClockWise(2,head);
    r.print(head);
}
    public Node rorateClockWise(int n,Node node){
        if(node==null ||n<0)
            return node;
       int size=getSize(node);
       if(n-size==0){
           return node;
       }
       int i=1;
       Node tmp=node;
       while (i<size-n){
           tmp=tmp.next;
           i++;
       }
      Node temp=tmp.next;
       Node head=temp;
       tmp.next=null;
         i=1;
       while (temp.next!=null){
           temp=temp.next;
       }
       temp.next=node;
        return head;
    }

    public int getSize(Node n){
        if(n==null)
            return 0;
        return getSize(n.next)+1;

    }

    public Node rotateAntiClockWise(int n,Node node){

    if(node==null || n<0){
        return node;
    }
    int size=getSize(node);
    if(n%size==0){
        return node;
    }
    Node tmp=node;
    int i=1;
    while (i<n){
        tmp=tmp.next;
        i++;
    }

    Node temp=tmp.next;
    Node head=temp;
    tmp.next=null;
    i=1;
    while (temp.next!=null){
        temp=temp.next;
    }
    temp.next=node;

    return head;
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
}
