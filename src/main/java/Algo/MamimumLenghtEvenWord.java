package Algo;

public class MamimumLenghtEvenWord {

    public static void main(String[] args) {
        String str = "this is a test strings";

        System.out.println( word(str));
    }

    public static String word(String input){

        int n=input.length();

        int maxlen=0;
        int currlen=0;
        int i=0;
        int startIndex=-1;
        while (i<n){
            if(input.charAt(i)==' '){
                if(currlen%2==0){
                    if(maxlen<=currlen){
                        maxlen=currlen;
                        startIndex=i-currlen;
                    }

                }
                currlen=0;
            }else{
                currlen++;
            }
i++;
        }

        if(currlen%2==0){
            if(maxlen<=currlen){
                maxlen=currlen;
                startIndex=i-currlen;
            }

        }

        if(startIndex==-1)
            return "-1";
        return input.substring(startIndex,startIndex+maxlen);
    }
}
