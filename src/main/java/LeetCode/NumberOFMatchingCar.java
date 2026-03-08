package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOFMatchingCar {
    public static void main(String[] args) {
        String cars[]={"0011","0111","0111","0110","0000"};
              //  {"100","110","010","011","100"};
        Arrays.stream(solution(cars)).forEach(i->System.out.println(i));

        }


    public static int[] solution(String[] cars) {
            List<Integer>result=new ArrayList<Integer>();
            int count=0;
            int resultCount=0;
            for(int i=0;i<cars.length;i++) {
                for (int k =0; k < cars.length; k++) {
                    if(i!=k) {
                        for (int j = 0; j < cars[i].length(); j++) {
                            if (cars[i].charAt(j) != cars[k].charAt(j)) {
                                count++;
                            }
                        }
                        if (count <= 1) {
                            resultCount++;
                        }
                        count = 0;
                    }
                }
                result.add(resultCount);
                resultCount=0;
            }
           return  result.stream().mapToInt(i -> i).toArray();
        }
}

