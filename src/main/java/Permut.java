import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Permut {
    public static void main(String[] args) {

    }



private Map<Character,Integer> buildMap(String s){

    Map<Character,Integer> map=new HashMap<>();

            for(int i=0;i<s.length();i++){

                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                }else{
                    map.put(s.charAt(i),1);
                }
            }

        return  map;
}
//abc     bac, cabe3


public String permut(Map map,String s){

      Iterator it= map.keySet().iterator();

      while (it.hasNext()){
          Character key=(Character) it.next();
         Integer data= Integer.parseInt(map.get(key)+"");
      }
      return null;
}

}
