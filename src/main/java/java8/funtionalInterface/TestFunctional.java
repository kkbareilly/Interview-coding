package java8.funtionalInterface;

import BinaryTree.SumOfNodes;

public class TestFunctional {
    public static void main(String[] args) {
        sumOFNumber no=(a,b)->{
         return a+b;
        };
        System.out.println(no.sum(4,5));
    }

}


 interface sumOFNumber{
    public int sum(int a,int b);
}