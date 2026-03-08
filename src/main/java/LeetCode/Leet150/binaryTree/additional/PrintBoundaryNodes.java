package LeetCode.Leet150.binaryTree.additional;

public class PrintBoundaryNodes {


private  void PrintBoundaryNode(Node node){
    printLeft(node.left);
    printLeaf(node.left);
    printLeaf(node.right);
    printRight(node.right);
}

    public void printLeft(Node node){
        if(node==null)
            return;
        if(node.left!=null){
            System.out.println(node.data);
            printLeft(node.left);
        }else if(node.right!=null){
      System.out.println(node.data);
      printLeft(node.right);
        }
    }
    public void printRight(Node node){
        if(node==null)
            return;
        if(node.right!=null){
            printLeft(node.right);
            System.out.println(node.data);

        }else if(node.left!=null){
            printLeft(node.left);
            System.out.println(node.data);

        }
    }
    public void printLeaf(Node node){
       if(node==null)
           return;
       printLeaf(node.left);
       if(node.left==null&&node.right==null){
           System.out.println(node.data);
       }
       printLeaf(node.right);
    }
}
