package LinkList;

public class AddOneToList {


    public int addOneToList(Node node){
        if(node==null)
            return 1;
        int res=node.data+addOneToList(node.next);
        node.data=res%10;
        return res/10;

    }

    public Node addOne(Node node){
        int c=addOneToList(node);
        if(c==1){
            Node head=new Node(1);
            head.next=node;
            return head;
        }
        return node;
    }
}
