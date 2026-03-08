package LinkList;


public class ReverseLinkList {

    public static void main(String[] args) {
        Node n=new Node(1000);
        Node n1=new Node(2000);
        Node n2=new Node(3000);
        Node n3=new Node(4000);
       Node p1= insertAtFirstPos(n,n1);
        Node p2= insertAtFirstPos(p1,n2);
        Node p3= insertAtFirstPos(p2,n3);

        Node t=new Node(400);
        Node t1=new Node(20);
        Node t2=new Node(4000);
        Node t3=new Node(700000);
        Node s1= insertAtFirstPos(t,t1);
        Node s2= insertAtFirstPos(s1,t2);
        Node s3= insertAtFirstPos(s2,t3);
        Node result=mergeTwoLinkedList(p3,s3);
       // n.getNext()
     printNode(mergeTwoListRev(p3,s3));
    }

    private static Node mergeTwoLinkedList(Node node1,Node node2){

        Node head=new Node(0);
        Node current=head;

        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        while (node1!=null && node2!=null){

            if(node1.getData()>=node2.getData()){
                current.next=node1;
                node1=node1.next;
            } else if(node2.getData()>=node1.getData()){
                current.next=node2;
                node2=node2.next;
            }
        }
        if(node1!=null){
            current.next=node1;
        }
        if(node2!=null){
            current.next=node2;
        }
        return head.next;
    }

    private static Node mergeTwoListRev(Node node1,Node node2){

        Node head=new Node(0);
       // Node current=head;

        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        if(node1.getData()>=node2.getData()){
            head=node1;
           head.next= mergeTwoListRev(node1.next,node2);
        } else{
            head=node2;
           head.next= mergeTwoListRev(node2.next,node1);
        }

        return head;
    }
    private Node ReverseInPair(Node node){

        if(node!=null ||  node.next!=null){
            Node temp=node.next;
            node.next=temp.next;
            temp.next=node;
            node=temp;
            node.next.next=ReverseInPair(node.next.next);

        }
        else {
            return null;
        }
        return node.next;
    }

    private static Node insertAtFirstPos(Node root,Node newNode){

        if(root!=null){
            newNode.setNext(root);;
            root=newNode;;
           // length=length+1;
        }
        return root;

    }

    private static void printNode(Node root){

        while (root!=null){
            System.out.println(root.getData());
            root=root.getNext();
        }
    }
}
