package LinkList;

public class LowestCommonElement {



    public Node lowestCommon(Node a,Node b){

        SortLinkList sort=new SortLinkList();
       Node first= sort.mergeSort(a);
       Node second= sort.mergeSort(b);
       Node temp=new Node();

       while (first!=null&&second!=null){

           if(first.data<second.data){
               first=first.next;
           }else if(second.data<first.data){
               second=second.next;
           }else{
               temp=a;
               temp.next=null;
               return temp;
           }
       }
       return null;
    }
}
