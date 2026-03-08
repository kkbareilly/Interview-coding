package LinkList;

import java.security.PublicKey;

public class SortLinkList {

public static void main(String[] args){
    Node root=new Node();
    root.setData(4);
    SortLinkList r=new SortLinkList();

    Node head= r.insertAtBeginning(root,5);
    head= r.insertAtBeginning(head,9);
    head= r.insertAtBeginning(head,7);
    head= r.insertAtBeginning(head,6);
    r.print(head);
    System.out.println("=========");
  head= r.mergeSort(head);
    r.print(head);
}

    public Node mergeSort(Node node){
        if(node==null || node.next==null)
            return node;
        Node middleElement=getMiddle(node);
        Node secondHalf=middleElement.next;
        middleElement.next=null;
        return merge(mergeSort(node),mergeSort(secondHalf));
    }
    private Node merge(Node a,Node b){

        Node temp=new Node();
        Node finalList=temp;
        while (a!=null && b!=null){
            if(a.data<b.data){
                temp.next=a;
                a=a.next;
            }else{
                temp.next=b;
                b=b.next;
            }
            temp=temp.next;
        }
        temp.next=(a==null)?b:a;
        return finalList.next;
    }
private Node getMiddle(Node node){
        if(node==null )
             return node;
        Node a=node;
        Node b=node.next;
        while (b!=null && b.next!=null){
            a=a.next;
            b=b.next.next;
        }
        return a;
}

public Node mergeLinkList(Node a, Node b){
    return merge(mergeSort(a),mergeSort(b));
}

   /* public Node mergeSort(Node node){
        if(node==null)
            return node;
        Node middle=middleNode(node);
        Node secondList=middle.next;
        middle.next=null;
        return merge(mergeSort(node),mergeSort(secondList));
    }
    public Node merge(Node a,Node b){
          Node temp=new Node();
          Node finalList=temp;
          while (a!=null && b!=null){
              if(a.data<b.data){
                  temp.next=a;
                  a=a.next;
              }else{
                  temp.next=b;
                  b=b.next;
              }
              temp=temp.next;
          }
          temp.next=(a==null)?b:a;
          return finalList.next;

    }
    public Node middleNode(Node node){
        if(node==null)
            return null;
        Node a=node;
        Node b=node.next;
        while (b!=null && b.next!=null){
            a=a.next;
            b=b.next.next;
        }
        return a;
    }*/
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
}
