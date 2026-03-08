package LinkList;

public class FlattenLinkedListlevelwise {



    public Node flatten(Node node){
         if(node==null)
             return node;
         Node start,end;
         start=end=node;
         while (end.next!=null){
             end=end.next;
         }
        while (start.next!=null){
            if(start.child!=null) {
                end.next = start.child;
                end = end.next;

                while (end.next != null) {
                    end = end.next;
                }
            }
            start=start.next;
        }
      return node;
    }
}
