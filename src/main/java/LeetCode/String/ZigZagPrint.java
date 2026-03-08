package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class ZigZagPrint {
  public static void main(String[] args) {
    //
      String s = "PAYPALISHIRING"; int numRows = 3;
    System.out.println(zigZag(s,numRows));
  }

    public static String zigZag(String s,int targer){
        Map<Integer,StringBuilder> data=new HashMap<>();
        boolean incr=true;
        StringBuilder result=new StringBuilder();
        int pos=0;
        for(char c:s.toCharArray()){
            if(pos==targer){
                incr=false;
            }
            if (pos==1)
                incr=true;
            if(incr) pos++; else pos--;
            if(!data.containsKey(pos))
                data.put(pos,new StringBuilder());
           data.get(pos).append(c);
        }
        for(int keys:data.keySet()){
            result.append(data.get(keys));
        }
        return result.toString();
    }
}
