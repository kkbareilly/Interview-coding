package Algo;

public class NumberOfRefillToCompleteJourney {

    public static void main(String[] args) {
        int N = 10;
        int K = 2;
        int M = 3;
        // compulsory petrol
        // pumps to refill at
        int compulsory[] = { 6, 7, 8 };

        // function call that returns
        // the answer to the problem
        System.out.println(countRefill(N, K,
                M, compulsory));
    }
    public static int countRefill(int N,int K,int M,int compulsory[]){

        int count=0;
        int i=0;
        int distCovered=0;
while (distCovered<N){

    // If must visited petrol pump lie
    // between distCovered and distCovered+K.
        if (i<M&& compulsory[i]<=distCovered+K){
            // make last mustVisited
            // as distCovered
               distCovered=compulsory[i];
               i++;
        }else
            distCovered+=K;
        if(distCovered<N){
            count++;
        }
    }
return count;
    }
}
