package LeetCode.Leet150.binaryTree;

import java.util.Stack;

public class BinarySearchTreeIterator {

  Stack<Node> st = new Stack<>();

    public BinarySearchTreeIterator(Node root) {

    }

    void partialInOrder(Node node){
        while (node!=null){
            st.push(node);
            node=node.left;
        }
    }
    public int next() {
       Node n=st.pop();
        partialInOrder(n.right);
       return n.data;
    }

    public boolean hasNext() {
       return !st.isEmpty();
    }
}
