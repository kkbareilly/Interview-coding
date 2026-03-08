package company.expedia;

//A conveyor belt has packages that must be shipped from one port to another within B days. The ith package on the conveyor belt has a weight of A[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship. Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within B days.
//
//Example 1
//
//A = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] B = 5
//Ans - 15
//Explaination
//we need to ship the packages within 5 days, so minimumin capacity of ship we need is 15 because we will ship in following ways:
//day 1 - [1, 2, 3, 4, 5] = total weight = 15
//day 2- [6, 7], total weight = 13
//day 3 - [8], total weight = 8
//day 4 -[9], total weight = 9
//day 5 -[10], total weight = 10
public class Conveyorbelt {



    int computeDayUtils(int []weights, int wei)
    {
        int days = 1;
        int currsum = 0;

        for(int i=0;i<weights.length;i++)
        {
            if(currsum + weights[i] <= wei)
            {
                currsum += weights[i];
            }
            else
            {
                days++;
                //we know atleast 1 value as whole can be adjusted in wei, as we took start limit as maxval
                currsum = weights[i];
            }
        }

        return days;
    }

    int shipWithinDays(int[] weights, int days) {

        //to decide on the range for BS
        int maxval = weights[0];
        int n = weights.length;

        for(int i=0;i<n;i++)
        {
            maxval = Math.max(maxval, weights[i]);
        }

        int start = maxval;//to fit in atleast each value in 1 day slot
        int end = maxval * n;
        int res = end;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            //cout<<mid<<endl;

            int currdays = computeDayUtils(weights, mid);
            //cout<<currdays<<endl;
            //base on currdays, we can take the call to increase/decrease the weight (mid) value of ship

            if(currdays > days)
            {
                //increase the value, to reduce days
                start = mid + 1;
            }
            else
            {
                //lower the value to its min, to increase days till threshold
                res = mid;
                end = mid - 1;
            }

        }

        return res;
    }
}
