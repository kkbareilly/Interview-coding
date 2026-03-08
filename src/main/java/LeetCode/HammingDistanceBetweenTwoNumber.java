package LeetCode;

public class HammingDistanceBetweenTwoNumber {
    public static void main(String[] args) {
       System.out.println( hDistance(15,4));
    }

    public static int hDistance(int x, int y) {
        int count = 0;
        int z = x ^ y;
        for (int i = 0; i < 32; i++) {
            if ((z >> i & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}