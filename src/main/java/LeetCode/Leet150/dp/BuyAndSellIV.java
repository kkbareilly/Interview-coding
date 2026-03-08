package LeetCode.Leet150.dp;

import java.util.Arrays;

/**
 You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

 Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

 Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).



 Example 1:

 Input: k = 2, prices = [2,4,1]
 Output: 2
 Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 */
public class BuyAndSellIV {
    public int maxProfit(int k, int[] prices) {
       int n= prices.length;
         int dp[][]=new int[k+1][n];
         if(n<2)
          return 0;
         for(int i=1;i<=k;i++){
             int buyingPrice=prices[0];
             for(int j=1;j<n;j++){
                 dp[i][j]=Math.max(dp[i][j-1],prices[j]-buyingPrice);
                 buyingPrice=Math.min(buyingPrice,prices[j]-dp[i-1][j]);
             }
         }
         return dp[k][n-1];
    }

    public int maxProfit1(int k, int[] prices) {
        int sell[] = new int[k+1];
        int buy[] = new int[k+1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i < k+1; i++) {
                buy[i] = Math.max(buy[i], sell[i-1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }

}
