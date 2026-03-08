package Algo;

public class UrlSortning {

    public static void main(String[] args) {
        int id=1234;
        String url=shortIdToUrl(id);
        System.out.println(url);
        System.out.println("system:"+shortUrlToId("kksingh"));
    }

    public static double shortUrlToId(String s){
         double id=0;
        for(int i=0;i<s.length();i++){
            if('a'<=s.charAt(i)  &&s.charAt(i)<='z' ){
                id=id*62+s.charAt(i)-'a';
            }else if('A'<=s.charAt(i) && s.charAt(i)<='Z'){
                id=id*62+s.charAt(i)-'A'+26;
            }else if('0'<=s.charAt(i) && s.charAt(i)<='9'){
                id=id*62+s.charAt(i)-'0'+52;

            }

        }
        return id;

    }

    public static String shortIdToUrl(int  n){
        char map[]="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuilder shortUrl=new StringBuilder();
        while(n>0){
            shortUrl.append(map[n%62]);
            n=n/62;
        }

        return shortUrl.reverse().toString();
    }
}
