package String;

public class ReverseWordsInString {

    public static void main(String[] args) {

        String s="abc my name";
        String final_result="";
        String temp="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ')
                temp=s.charAt(i)+temp;
            else{
                final_result=final_result+temp+" ";
                temp="";
            }
        }
        final_result=final_result+temp;

        System.out.println(final_result);
    }


}
