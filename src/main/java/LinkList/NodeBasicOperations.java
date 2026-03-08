package LinkList;

public class NodeBasicOperations {
static int length;
    public static void main(String[] args) {
        Node root=new Node();

        insertAtFirstPos(root,new Node(200));
        insertAtFirstPos(root,new Node(300));
        insertAtFirstPos(root,new Node(400));
        insertAtFirstPos(root,new Node(500));
        insertAtPosition(45,3,root);
        printNode(root);
    }


    private static Node insertAtFirstPos(Node root,Node newNode){

        if(root!=null){
            newNode.next=root;;
            root=newNode;;
            length=length+1;
        }
        return root;

    }

    private static Node insertAtPosition(int data,int position,Node root){
       if(position<0)
           position= 0;
       if(position>length)
           position= length;
       else if(position==0)
       {
           Node newNode=new Node();
           newNode.setData(200);
           newNode.next=root;
           root=(newNode);
       }else{
          Node p=root; Node q=null;
          int i=1;
          while (i<position){
              q=p;
             p=p.next;
             i=i+1;

          }
          Node newNode=new Node(900);
          newNode.next=(p);
          q.next=(newNode);
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
