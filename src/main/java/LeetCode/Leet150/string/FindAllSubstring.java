package LeetCode.Leet150.string;

public class FindAllSubstring {

    public static void main(String[] args){
        printSubString("abc");
    }

    public static void printSubString(String s){

        for(int i=0;i<s.length();i++){
            StringBuffer sb=new StringBuffer();
            for(int j=i;j<s.length();j++){
               sb.append(s.charAt(j));
                System.out.println(sb);
            }
        }
    }
}
