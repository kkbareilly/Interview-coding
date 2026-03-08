package LinkList;

public class LongestPelindromicList {


    public int getPalindromSize(Node node){
        if(node==null)
            return 0;
        if(node.next==null)
            return 1;
        Node next,prev;
        next=prev=null;
        int result=1;
        while (node!=null){
            next=node.next;
            node.next=prev;
            result=Math.max(result,2*commonElement(prev,next)+1);
            result=Math.max(result,2*commonElement(node,next));
           prev=node;
           node=next;

        }
         return result;
    }
    public int commonElement(Node a,Node b){
        int count=0;
        while (a!=null && b!=null){
            if(a.data==b.data)
                count++;
            else
             break;;
             a=a.next;
             b=b.next;
        }
        return count;
    }
}
