package LeetCode;

public class FirstRepeatingCharactor {

    public static void main(String[] args) {
        String s="abcdxyxa";
        System.out.println(solve(s));
    }
    public static String solve(String str){

        String temp="";
        for(int i=0;i<str.length();i++){
            if(temp.contains(""+str.charAt(i))){
                return ""+str.charAt(i);
            }
            temp=temp+str.charAt(i);
        }
        return "";
    }
}
