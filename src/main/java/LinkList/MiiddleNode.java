package LinkList;

public class MiiddleNode {

    public static void main(String[] args){
        Node root=new Node();
        root.setData(4);
        MiiddleNode r=new MiiddleNode();

        Node head= r.insertAtBeginning(root,5);
        head= r.insertAtBeginning(head,9);
       // head= r.insertAtBeginning(head,7);
       // head= r.insertAtBeginning(head,6);
        r.print(head);
        System.out.println("==========");
       Node n= r.findMiddleNode(head);
    System.out.println(n.data);
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

    public Node findMiddleNode(Node node){
        if(node==null)
            return null;
        Node a=node;
        Node b=node.next;
        while (b!=null && b.next!=null){
            a=a.next;
            b=b.next.next;
        }
        return a;
    }
}
