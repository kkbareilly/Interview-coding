package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PizzSlicing {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        System.out.println("Pleas end number");
        String n=br.readLine();
         int i=Integer.parseInt(n);
         List<Double> result=new ArrayList<>();
        while (i>0){
            i--;
            String a=br.readLine();
            String st[] = a.split(" ");

              int r=Integer.parseInt(st[0]);
            int numberOfPeople=Integer.parseInt(st[1]);
            int angle=Integer.parseInt(st[2]);
            int minute=Integer.parseInt(st[3]);
            int second=Integer.parseInt(st[4]);
            float calculatedAngle=0;
             if(minute>0 || second>0){

                 calculatedAngle=(minute+(second/60f))/60f;
             }
             //area=r2* ((3.14/180) *angle)/2
             double calculatedArea=Math.pow(r,2)* (((3.14/180))*(angle+calculatedAngle)/2);
            result.add(calculatedArea);

        }

        result.stream().forEach(data->{
            System.out.println(data);
        });
    }
}
