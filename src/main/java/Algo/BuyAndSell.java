package Algo;

public class BuyAndSell {
    public static void main(String[] args) {
        int prices[] = { 17, 1, 5, 3, 6, 4 };
        System.out.print(solve(prices));
    }

    public static int solve(int a[]){

        int lenght=a.length;
        int max=0;
        int min=a[0];
        int cost=0;
        int mxcost=0;

        int minIndex=0;
        int maxIndex=0;

        for(int i=0;i<lenght;i++){
//
//            if(min>a[i]){
//                min=a[i];
//                minIndex=i;
//                System.out.println("inside="+min);
//
//            }
//
//            // since min_price is smallest element of the
//            // array so subtract with every element of the
//            // array and return the maxCost
//
//            cost = a[i] - min;
//
//            mxcost = Math.max(mxcost, cost);

            if(min>=a[i]){
                min=a[i];
                minIndex=i;
            }
            cost=a[i]-min;
           if(mxcost<cost) {
               mxcost=cost;
               maxIndex=i;
           }
        }
        System.out.println(a[minIndex]+"   "+a[maxIndex]);
        return mxcost;
    }
}
