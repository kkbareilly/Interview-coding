package LinkList;

public class UnionOfLinkList {


    public Node getUnit(Node a,Node b){
        SortLinkList sort=new SortLinkList();
        Node first=sort.mergeSort(a);
        Node second=sort.mergeSort(b);
        return union(first,second);
    }

    public Node union(Node a,Node b){

        Node temp=new Node();
        Node head=temp;
        while (a!=null && b!=null){
            if(a.data<b.data){
                temp.next=a;
                a=a.next;
            }else if(a.data>b.data){
                temp.next=b;
                b=b.next;
            }else{
                temp.next=a;
                a=a.next;
                b=b.next;
            }
            temp=temp.next;
        }
        temp.next=(a==null)?b:a;
        return head.next;
    }
}
