package LeetCode.Leet150.stack;

import java.util.Stack;

public class BasicCalculator {
public static void main(String[] args){
    String s="(1+(4+5+2)-3)+(6+8)";
    System.out.println(calculate(s));
}
    public static int calculate(String s) {

        int sing=1;
        Stack<Integer>st=new Stack<>();
        int sum=0;

        for(int i=0;i<s.length();i++){
            int num=0;
            if(s.charAt(i)>='0'&& s.charAt(i)<='9'){
                while (i<s.length() && s.charAt(i)>='0'&& s.charAt(i)<='9'){
                    num=num*10+s.charAt(i)-'0';
                   i++;
                }
                sum+=num*sing;
                i--;
            }
            else if(s.charAt(i)=='-'){
                sing=-1;
            }else if(s.charAt(i)=='+'){
                sing=1;
            }else if(s.charAt(i)=='('){
                st.push(sum);
                st.push(sing);
                sum=0;
                sing=1;
            }else if(s.charAt(i)==')'){
                sum=st.pop()*sum;
                sum+=st.pop();
            }
        }
        return sum;
    }


    int index= 0;
    public int calculate1(String s) {
        int sum =0;
        int total = 0;
        int sign = 1;
        while(index < s.length()){
            char c = s.charAt(index);
            if(Character.isDigit(c)){
                sum = sum * 10 + (c - '0');
            }else if ( c == '+' || c == '-'){
                total = total + sign * sum;
                sign = (c == '+')? 1 : -1;
                sum = 0;
            }else if( c == '('){
                index++;
                sum = calculate1(s);
            }else if ( c == ')'){
                return total + (sign * sum);
            }
            index++;
        }

        return total + sign * sum;
    }
}
