package BinaryTree;

public class InOrderPreOrderTOBinaryTree {

    static int preIndex = 0;
    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    // driver program to test above functions
    public static void main(String args[])
    {
        InOrderPreOrderTOBinaryTree tree = new InOrderPreOrderTOBinaryTree();
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
    public  Node buildTree(char in[],char pre[],int inStart,int inEnd){
        Node root;
        if(inStart>inEnd)
            return null;
        Node tNode=new Node(pre[preIndex++]);
        if(inStart==inEnd)
            return tNode;
         int pIndex=search(in,inStart,inEnd,tNode.data);
         tNode.left=buildTree(in,pre,inStart,pIndex-1);
        tNode.right=buildTree(in,pre,pIndex+1,inEnd);
        return tNode;

    }
    public int search(char a[],int start,int end,int value){

        for(int i=start;i<=end;i++){
            if(a[i]==value)
                return i;
        }
        return 0;
    }

    class Node{

        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
}

