package LinkList;

public class RemoveDuplicate {


    public Node removeDuplicate(Node node){
        if(node==null ||node.next==null)
            return node;
        if(node.data==node.next.data){
            node.next=node.next.next;
            removeDuplicate(node);
        }else{
            removeDuplicate(node.next);
        }
        return node;
    }
}
