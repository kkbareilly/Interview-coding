package BinaryTree;

public class CreateDoubleTree {

    public Node doubleTree(Node node){
        if(node==null)
            return null;
        doubleTree(node.left);
        doubleTree(node.right);
        Node newNode=new Node(node.data);
        newNode.left=node.left;
        node.right=newNode;
        return node;
    }
}
