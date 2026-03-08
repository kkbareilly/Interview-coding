package LeetCode.Leet150.binariSearch;

public class SqureRoot {
    static double Square(double n,
                         double i, double j)
    {
        double mid = (i + j) / 2;
        double mul = mid * mid;

        // If mid itself is the square root,
        // return mid
        if ((mul == n) ||
                (Math.abs(mul - n) < 0.00001))
            return mid;

            // If mul is less than n,
            // recur second half
        else if (mul < n)
            return Square(n, mid, j);

            // Else recur first half
        else
            return Square(n, i, mid);
    }

    // Function to find the square root of n
    static void findSqrt(double n)
    {
        double i = 1;

        // While the square root is not found
        boolean found = false;
        while (!found)
        {

            // If n is a perfect square
            if (i * i == n)
            {
                System.out.println(i);
                found = true;
            }

            else if (i * i > n)
            {

                // Square root will lie in the
                // interval i-1 and i
                double res = Square(n, i - 1, i);
                System.out.printf("%.5f", res);
                found = true;
            }
            i++;
        }
    }
    public static double mySqrt(double x) {
        if(x==0)
            return 0;
        double start=1;
        double end=x;
        while (start<end){
            double mid=start+(end-start)/2;
            if(mid==x/mid)
                return mid;
            else if(mid<x/mid){
                start=mid+1;
            }else if(mid>x/mid){
                end=mid-1;
            }
        }
        return end;
    }
    // Driver code
    public static void main(String[] args)
    {
        double n = 6;
      findSqrt(n);
    System.out.println( mySqrt(n));
   ;
    }
}
