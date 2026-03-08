package LeetCode.Leet150.string;

public class FindAllSubsequence {


    public static void printSubSequence(String input,String output){
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        //exclude 1st char from output
        printSubSequence(input.substring(1),output);
        printSubSequence(input.substring(1),output+input.charAt(0));
        //include first character from out put
    }
    public static void main(String[] args){
        printSubSequence("xyz","");
    }
}
