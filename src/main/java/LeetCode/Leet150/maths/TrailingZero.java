package LeetCode.Leet150.maths;

/**
 * Intuition
 * The number of trailing zeroes in a factorial is determined by the number of times 10 can be formed as a factor in the factorial. Since 10=2×5, and there are always more factors of 2 than 5 in a factorial, the count of trailing zeroes is equal to the number of factors of 5 in the factorial.
 * 🛠️ Approach
 * To calculate the number of factors of 5:
 * Divide n by 5 and record how many multiples of 5 exist up to n.
 * Continue dividing n by higher powers of 5 (e.g.,25,125,…) to account for numbers that contribute more than one factor of 5.
 * Sum all these counts to get the total number of trailing zeroes.
 * This approach is efficient because it avoids calculating the factorial explicitly and instead focuses on counting the factors of 5 directly.
 * Complexity
 * ⏳Time complexity:O(log
 * 5
 * ​
 *  n)
 * Each division by 5 reduces n, making this logarithmic in terms of the base 5.
 * 📦Space complexity:O(1)
 * The solution uses a constant amount of space.
 */
public class TrailingZero {

    public int trailingZeroes(int n) {
        int res=0;
        while(n>0){
            n=n/5;
            res+=n;
        }
        return res;
    }
}
