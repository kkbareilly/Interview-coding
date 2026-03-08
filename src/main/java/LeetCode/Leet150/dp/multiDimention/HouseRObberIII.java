package LeetCode.Leet150.dp.multiDimention;

import BinarySearchTree.Node;
//when array is circular
public class HouseRObberIII {
int rob(Node node){
    int options[]=travel(node);
    return Math.max(options[0],options[1]);
}
public int[] travel(Node node){
    if(node==null)
        return new int[2];
    int[]leftNodeChoices=travel(node.left);
    int[]rightNodeChoices=travel(node.left);
    int[] options=new int[2];
//store value if looted in [0]
    options[0]=node.data+leftNodeChoices[1]+rightNodeChoices[1];
    options[1]=Math.max(leftNodeChoices[0],leftNodeChoices[1] )+
            Math.max(rightNodeChoices[0],rightNodeChoices[1] );
    return options;


}




}
