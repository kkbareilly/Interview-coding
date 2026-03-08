package Algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CombinationOfPhoneNumber {
    public static void main(String[] args) {
        String table[]={" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","xyz"};
        String number="24557";
        List<String>wors=words(number,number.length(),table);
        wors.stream().forEach(x->System.out.println(x));
    }

    public static List<String> words(String number,int n,String []table){

        List<String> list=new ArrayList<>();
        Queue<String> q=new LinkedList<>();

        q.add(" ");
        while(!q.isEmpty()){

            String s=q.poll();
            if(s.length()==n)
                list.add(s);
            else{
                String val=table[Character.getNumericValue(number.charAt(s.length()))];
                for(int i=0;i<val.length();i++){
                    q.add(s+val.charAt(i));
                }
            }
        }

        return list;
    }
}
