package BinaryTree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root==null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        rserialize(root,sb);
        return sb.toString();
    }

    private void rserialize(Node root,StringBuilder sb) {
        if(root==null) {
            sb.append("null,");
        }else {
            sb.append(root.data+",");
            rserialize(root.left,sb);
            rserialize(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data==null||data.isEmpty())
            return null;
        String[] darray=data.split(",");
        List<String> lis = new ArrayList<>(Arrays.asList(darray));
        return rdeserialize(lis);
    }

    private Node rdeserialize(List<String> lis) {
        if(lis.get(0).equals("null")) {
            lis.remove(0);
            return null;
        }
        Node root=new Node(Integer.parseInt(lis.get(0)));
        lis.remove(0);
        root.left=rdeserialize(lis);
        root.right=rdeserialize(lis);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));