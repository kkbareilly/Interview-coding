package LeetCode;

public class PowerOfNuber {
    public static void main(String[] args) {
        System.out.println(pow(2));
    }
    public static boolean pow(int n){
        int i=1;
        while (i<n){
            i*=2;
        }
        return i==n;
    }
}
