package company.expedia;

import java.util.Stack;

public class SortStack {

    private  void sort(Stack<Integer> s){

    Stack<Integer> temp = new Stack<>();

        while(!s.empty())
        {
            int curr = s.peek();
            s.pop();

            while(!temp.empty() && temp.peek() > curr)
            {
                int val = temp.peek();
                temp.pop();

                s.push(val);
            }

            temp.push(curr);
        }

        s = temp;
    }
}
