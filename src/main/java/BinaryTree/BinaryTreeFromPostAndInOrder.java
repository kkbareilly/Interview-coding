package BinaryTree;

public class BinaryTreeFromPostAndInOrder {



    public Node buildTree(int in[],int post[],int inStart,int inEnd,int postStart,int postEnd) {

        if (inStart > inEnd)
            return null;
        Node tNode = new Node(post[postEnd]);
        if (inStart == inEnd)
            return tNode;
        int inIndex = search(in, inStart, inEnd, tNode.value);
        tNode.left = buildTree(in, post, inStart, inIndex - 1, postStart, postStart - inStart+inIndex - 1);
        tNode.right = buildTree(in, post,  inIndex + 1,inEnd, postEnd-inEnd+inIndex, postEnd-1);
        return tNode;
    }


    public int search(int in[],int stat,int end,int value){
        for(int i=stat;i<end;i++){
            if(in[i]==value)
                return i;
        }
        return 0;
    }
    class Node{
        int value;
        Node left;
        Node right;

                Node(int value){
                    this.value=value;
                    this.left=this.right=null;
                }
    }
}
