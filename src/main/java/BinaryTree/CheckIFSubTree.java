package BinaryTree;

public class CheckIFSubTree {


    public static  boolean isSubTree(Node main,Node sub){

        if(sub==null) return false;
        if(main==null) return false;

        if(isSubIdentical(main,sub))
            return true;
        return isSubTree(main.left,sub)|| isSubTree(main.right,sub);
    }

    private static boolean isSubIdentical(Node main, Node sub) {
        if(main==null && sub==null)
            return true;
        if(main==null || sub==null)
            return false;
        return isSubIdentical(main.left,sub.left)|| isSubIdentical(main.right,sub.right);
    }
}

//inorder+preorder
//inorder+postorder
//convert both tree in the above any one of the combination and then check contains sub tree String in main tree string