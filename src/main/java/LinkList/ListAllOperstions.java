package LinkList;

public class ListAllOperstions {

    public static int length=0;


    public static void main(String[] args) {
        Node n=new Node(40);
       Node n1 =insertAtBeginning(n,50);
        Node n2 = insertAtBeginning(n1,100);
        Node n3 = insertAtBeginning(n2,200);
       Node n4 =insertAtBeginning(n3,300);
       Node root= insertAtBeginning(n4,400);

       Node s= insertAtEnd(root);
       print(s);
       System.out.println("=============");
       // Node d=deleteFromPosition(s,2);
       // Node d=deleteFromBeginning(s);
        Node d=deleteFromEnd(s);


        print(d);

    }

    private static Node insertAtBeginning(Node root,int data){

        if(root!=null){

            Node n=new Node(data);
            n.next=root;
            root=n;
            length=length+1;
        }

       return root;
    }

    private static Node insertAtPosition(Node root,int pos,int data){
            if(pos<=0)
                pos=0;
            if (pos>length)
                pos=length;

            int i=0;
            Node p=root;Node q=null;
            if(pos==0){

                Node n=new Node(data);
                n.next=root;
                root=n;
            }else {
                while (i < pos) {
                    q = p;
                    p = p.next;
                    i=i+1;
                }

                Node n = new Node(data);
                n.next = p;
                q.next = n;
            }

        return root;
    }
    private static Node insertAtEnd(Node root){

        if(root!=null){
             Node p=root;
             Node q=null;
            while (p.next!=null){
                q=p;
                p=p.next;
            }

Node n     =new Node(900);
            p.next=n;
            p=n;
        }
return  root;
    }
    private static Node deleteFromBeginning(Node root){
        Node node=root;

        if(node!=null){
            root=node.next;
            node.next=null;
        }
        length=length-1;
        return root;
    }

    private static Node deleteFromPosition(Node root,int pos){

        if(pos<=0)
            pos=1;
        if(pos>length)
            pos=length;
        int i=1; Node p=root;
        Node q=null;

        while (i<pos){
            q=p;
            p=p.next;
            i=i+1;
        }
       q.next=p.next;
        p.next=null;
        length=length-1;

        return root;
    }
    private static Node deleteFromEnd(Node root){

        if(root!=null)
        {
            Node p=root;
            Node q=null;

            while (p.next!=null){
              q=p;
              p=p.next;
            }
            q.next=null;
        }
return root;
    }


    private static void print(Node root){
        while (root!=null){
            System.out.println(root.getData());
            root=root.next;
        }
    }

}
