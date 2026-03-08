package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Advertizment {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        System.out.println("Pleas end number");
        String n=br.readLine();
        int i=Integer.parseInt(n);
        List<String> result=new ArrayList<>();
        while (i>0){
            i--;
            String a=br.readLine();
            String st[] = a.split(" ");

            int r=Integer.parseInt(st[0]);
            int e=Integer.parseInt(st[1]);
            int c=Integer.parseInt(st[2]);
            if(e>0 && e>r+c){
                result.add("advertise");
            }else if(e>0 && e==r+c){
                result.add("does not matter");

            }else{
                result.add("do not advertise");

            }


        }
        result.stream().forEach(data->{
            System.out.println(data);
        });
    }
}
