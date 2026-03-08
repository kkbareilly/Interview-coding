package LeetCode.Leet150.arraystring;

public class BuyAndSellStock {

    public static void main(String[] args){
        int stc[]={3,0,6,1,5};
    System.out.println(stock(stc));
    }
    public static int stock(int [] stc){
        int l=0;
        int r=0;
        int maxP=0;

        while (r<stc.length){
            if(stc[l]<stc[r]){
                int profit=stc[r]-stc[l];
                maxP=Math.max(maxP,profit);
            }else
                l=r;
            r++;
        }
        return maxP;
    }
}
