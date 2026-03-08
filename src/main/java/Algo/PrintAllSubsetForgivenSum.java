package Algo;

import java.util.Vector;

public class PrintAllSubsetForgivenSum {


    public  static void sum(int []a, int n, Vector v,int sum){

        if(sum==0){
            for(int i=0;i<v.size();i++){
                System.out.println(v.get(i));
            }

            System.out.println("=============");
            return;
        }
        if(n==0)
            return;
        sum(a,n-1,v,sum);
        Vector v1=new Vector(v);
        v1.add(a[n-1]);
        sum(a,n-1,v1,sum-a[n-1]);
    }

    public static void main(String[] args) {
        int sum = 10;

        int[] pat = {1, 2, 3, 4, 5};
        sum(pat,pat.length,new Vector(),sum);
    }
}
