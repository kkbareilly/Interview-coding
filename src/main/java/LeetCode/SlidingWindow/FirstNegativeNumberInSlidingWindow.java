package LeetCode.SlidingWindow;

import java.util.*;

public class FirstNegativeNumberInSlidingWindow {

    public static void main(String[] args) {
        int[]a={12,-1,-7,8,-15,30,16,28};
        getNegativeNumber(a,3).forEach(s->System.out.println(s));
    }
    public static List<Integer>getNegativeNumber(int a[],int k){

        int i=0;
        int j=0;
        List<Integer>result=new ArrayList<>();
        int count=0;
        Deque<Integer> stage=new LinkedList<>();
        while (j<a.length){
                stage.addLast(a[j]);
            if(j-i+1<k) {
                ++j;
            }
           else if(j-i+1==k){

                for (Iterator itr = stage.iterator(); itr.hasNext();) {
                    int data=(int)itr.next();
                    if(data<0){
                        result.add(data);
                        break;
                    }

                }
                j++;
                i++;
          stage.removeFirst();

            }
        }
        return result;
    }
}
