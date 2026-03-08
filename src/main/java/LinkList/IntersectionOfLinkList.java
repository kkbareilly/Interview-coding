package LinkList;

public class IntersectionOfLinkList {

    public Node getIntersection(Node a,Node b){
        SortLinkList sort=new SortLinkList();
        Node first=sort.mergeSort(a);
       Node second= sort.mergeSort(b);
       return intersection(first,second);

    }

    public Node intersection(Node a,Node b){
        Node temp=new Node();
        Node head=temp;
        while (a!=null && b!=null){
            if(a.data<b.data){
                a=a.next;
            }else if(b.data<a.data){
                b=b.next;
            }else{
                temp.next=a;
                temp=temp.next;
                a=a.next;
                b=b.next;

            }

        }
        temp.next=null;
        return head.next;
    }
}
