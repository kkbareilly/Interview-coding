package BinarySearchTree;

import java.util.Arrays;

public class CreateBalancedTree {


    public Node create(int a[]){
        Arrays.sort(a);
    return createBalancedTree(a,0,a.length-1);
    }

    public Node createBalancedTree(int a[],int start,int end){
        if(start>end)
            return null;
        int mid=start+(start+end)/2;
        Node n=new Node(a[mid]);
        n.left=createBalancedTree(a,start,mid-1);
        n.right=createBalancedTree(a,mid+1,end);
        return n;
    }
}
