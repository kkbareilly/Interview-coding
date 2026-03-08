package BinarySearchTree;

public class BST {

    public static void main(String[] args) {
       Node n= buildBST();
      print(n);
      System.out.println("----------");
      Node m=delete(n,10);
      print(m);
    }
    public static Node createNode(int value){
        return new Node(value);
    }

    public static Node insert(Node node,int val){
        if(node==null)
            return createNode(val);
        else if(val<node.data){
            node.left=insert(node.left,val);
        }else if(val>node.data){
            node.right=insert(node.right,val);
        }
        return node;
    }

    public  static Node buildBST(){
        Node root=null;
        root = insert(root, 8);
        root = insert(root, 3);
        root = insert(root, 6);
        root = insert(root, 10);
        root = insert(root, 4);
        root = insert(root, 7);
        root = insert(root, 1);
        root = insert(root, 14);
        root = insert(root, 13);
        return root;
    }

    public static Node delete(Node node,int  val){
        if(node==null)
            return null;
        if(val<node.data){
            node.left=delete(node.left,val);
        }else  if(val>node.data){
            node.right=delete(node.right,val);
        }else {
            if(node.left==null || node.right==null){
                Node temp=null;
                temp=node.left==null?node.right:node.left;
                if(temp==null)
                    return null;
                else
                    return temp;

            }else{
                Node successor=successor(node);
                node.data=successor.data;
                node.right=delete(node,successor.data);
              return node;
            }
        }
        return node;
    }

    public  static  Node successor(Node node){
        if(node==null)
            return null;
        Node temp= node.right;

        while (temp!=null){
            temp=temp.left;
        }
        return temp;
    }
    public  static void print(Node n){
        if(n==null)
            return;
        System.out.println(n.data);

        if(n.left!=null)
        {
            print(n.left);

        }

        if(n.right!=null){
            print(n.right);

        }
    }
}
