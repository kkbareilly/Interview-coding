package LeetCode.Leet150.arraystring;

public class JumpGame {

    public static void main(String[] args){
    System.out.println();
    }
    public static boolean game(int a[]){
        int goal=a.length-1;
        for(int i=a.length-1;i>-1;i--){
            if(i+a[i]>=goal)
                goal= i;
        }

        if(goal==0)
            return true;
        else
            return false;
    }
}
