package java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class FIleOps {
    public static void main(String[] args) throws IOException {
        Path path= Paths.get("./abc.txt");
      /* String data=Files.readString(path);
        System.out.println(data);
       String newString= data.replace("kk","pk");
       Files.writeString(Paths.get("./xyz.txt"),newString);*/
    }


    public static  boolean isEven(int number){
        return  number%2==0;
    }

    public void userNot(){
 /*       List<Integer> ls=List.of(1,2,3,4,5,6);
        ls.stream().filter(Predicate.not(FIleOps::isEven)).forEach(System.out::println);
        System.out.println("".isBlank());
        System.out.println(" ab ".strip());
        "kk\npk\n".lines().forEach(System.out::println);*/

    }
}
