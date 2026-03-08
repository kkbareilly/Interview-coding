package LeetCode.Arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ParkingDilema {
    public static void main(String[] args) {
        int a[]={2,10,8,17};
        System.out.println(carParkingRoof(a,3));
    }
    public static int  carParkingRoof(int []cars, int k) {
        int result=cars[k-1]-cars[0];

       int n = cars.length;
        Arrays.sort(cars);
         Arrays.stream(cars).forEach(s->System.out.println(s));
       //     #Find minimum value among
   // #all K size subarray.
        for(int i=0;i<n-k+1;i++){
            result = (Math.min(result, cars[i + k - 1] - cars[i] + 1));

        }
        return result;
    }
}
