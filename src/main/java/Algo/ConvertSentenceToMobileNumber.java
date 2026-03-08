package Algo;

public class ConvertSentenceToMobileNumber {


    public static void main(String[] args) {
        String a[]={
                "2","22","222",
                "3","33","333",
                "4","44","444",
                "5","55","555",
                "6","66","666",
                "7","77","777","7777",
                "8","88","888",
                "9","99","999","9999"
        };
       System.out.println( convert(a,"abcd"));
    }
    public static String convert(String [] a,String input){
        if(input==null)
            return null;
        String output="";
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==' '){
                output=output+"0";
            }else{
               int position= input.charAt(i)-'a';
               output+=a[position];
            }

        }
        return output;
    }
}
