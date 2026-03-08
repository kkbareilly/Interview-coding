package LeetCode.Leet150.bst;

import java.util.Arrays;

public class ArrayToBalanceBST {


    public Node balanceBST(int arr[],int start,int end){
        if(start>end)
            return null;
    Arrays.sort(arr);

    Node root=null;
    int mid=(start+end)/2;
    Node node=new Node(arr[mid]);
    node.left=balanceBST(arr,start,mid-1);
    node.right=balanceBST(arr,mid+1,end-1);
    return node;


    }
}
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}