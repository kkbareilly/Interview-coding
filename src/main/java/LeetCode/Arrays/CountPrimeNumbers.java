package LeetCode.Arrays;

import java.util.Arrays;

public class CountPrimeNumbers {
    int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++)
            if (isPrime[i])
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime[i]) count++;

        return count;
    }
}
 /*   The time complexity of the algorithm is difficult to calculate, and it is clear that the time is related to the two nested for loops, whose operands should be

        n/2 + n/3 + n/5 + n/7 + ... = n × (1/2 + 1/3 + 1/5 + 1/7...)

        The inverse of the prime number is in parentheses. The final result is O(N * loglogN)*/