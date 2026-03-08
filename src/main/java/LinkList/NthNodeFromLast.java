package LinkList;

public class NthNodeFromLast {



    private static Node nthNode(Node root,int nthNode){
        Node pTemp=root; Node pNthNode=null;

        for (int count=1;count<nthNode;count++){
            if(pTemp!=null){
                pTemp=pTemp. next;
            }
        }

        while (pTemp!=null){
            if(pNthNode==null)
                pNthNode=root;
            else
                pNthNode=pNthNode.next;
            pTemp=pTemp.next;
        }
        if(pNthNode!=null)
            return pNthNode;
        return null;
    }

    private static  Node revNthNode(Node root,int nth,int counter)
    {

        if(root!=null){
            revNthNode(root.next,nth,counter);
            counter++;
                    if(nth==counter){
                        return root;
                    }
        }
        return null;
    }
}
