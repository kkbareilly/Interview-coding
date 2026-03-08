package LinkList;

public class NullTerminatedOrCycle {




    private static boolean Cycle(Node root){

        if(root==null)
            return false;
        else
        {
            Node slowNode=root;
            Node fastNode=root;

            while (fastNode!=null && fastNode.next!=null){
                fastNode=fastNode.next.next;
                slowNode=slowNode.next;
                if(slowNode.data==fastNode.data)
                    return true;
            }
        }
        return false;
    }
}
