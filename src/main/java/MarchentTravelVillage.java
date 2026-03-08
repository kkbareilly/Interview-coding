import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarchentTravelVillage {
    public static void main(String[] args) {
        int inputs[] =  { 1, 2, 3, 4, 9, 8 };
        int numbers = 6;
       // System.out.println(TotalProfit(inputs, numbers));
        System.out.println(profit(inputs,numbers));
    }


    private static int TotalProfit(int[] p, int n)
    {
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < n - 1; i++)
        {
            int iterator = i + 1;
            while (iterator < n)
            {
                Compare(p[i], p[iterator],  moves);
                iterator++;
            }
        }

        return moves.stream().collect(Collectors.summingInt(i->i));
    }

    static void Compare(int i, int j,  List<Integer> moves)
    {
        if (i >= j || j != (i + i)) return;
        if (!moves.contains(i))
            moves.add(i);
        if (!moves.contains(j))
            moves.add(j);
    }


    static int profit(int arr [],int n ){
         int dp[]= new int[n];
        dp[0]=arr[0];
        for(int i=1;i<n;i++)
        {
            dp[i]=arr[i];
            for(int j=0;j<i;j++)
            {
                if(arr[j]<arr[i] && (arr[i]%arr[j])==0)
                    dp[i]=Math.max(dp[i],dp[j]+arr[i]);
            }
        }

        return dp[n-1];
    }
}
