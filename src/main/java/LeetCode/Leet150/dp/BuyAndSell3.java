package LeetCode.Leet150.dp;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 */
public class BuyAndSell3 {


    public int maxProfit(int[] prices) {
      return   buyAndSell(0,1,2,prices,prices.length);
    }

    public int buyAndSell(int index,int buy,int cap,int prices[],int n){
        if(index==n ||  cap==0) return 0;

        if(buy==1){
            return Math.max(-(prices[index])+buyAndSell(index+1,0,cap,prices,n),buyAndSell(index+1,1,cap,prices,n));
        }
        return Math.max((prices[index])+buyAndSell(index+1,1,cap-1,prices,n),buyAndSell(index+1,0,cap,prices,n));
    }
}
