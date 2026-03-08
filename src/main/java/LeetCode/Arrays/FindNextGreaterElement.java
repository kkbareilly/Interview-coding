package LeetCode.Arrays;

import java.util.Arrays;
import java.util.Stack;

public class FindNextGreaterElement {
  public static void main(String[] args) {
    int a[]={13,7,6,12,18,15};
    Arrays.stream(calculate(a)).forEach(d -> System.out.println(d));
  }

    public static int [] calculate(int a[]){
        int result[]=new int [a.length];
        Stack<Integer> st=new Stack();

        for(int i=0;i<a.length;i++){
            if(st.empty() || a[st.peek()]>=a[i]){
                st.push(i);
            }else {
                while ( !st.isEmpty() && a[st.peek()]<=a[i]){
                   int index= st.pop();
                   result[index]=a[i];
                }
                if(st.isEmpty()){
                    st.push(i);
                }
               else if(!st.isEmpty() &&a[st.peek()]>=a[i]){
                    st.push(i);
                }
            }
        }
        while (!st.isEmpty()){
            result[st.pop()]=-1;
        }
        return result;
    }
}
