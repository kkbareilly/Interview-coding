package LeetCode.Leet150.arraystring;

public class BuyAndSellStcokII {

    //Buy and sell any number of time
public static void main(String[] args){
    int a[]={7,1,5,3,6,4};
    System.out.println(profit(a));
}
    public static int profit(int a[]){
        int profit=0;
        for(int i=1;i<a.length;i++){
            if(a[i]>a[i-1]){
                profit+=a[i]-a[i-1];
            }
        }
        return profit;
    }
}
