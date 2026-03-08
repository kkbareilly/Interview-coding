package java9;

import sun.java2d.loops.ProcessPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CodeTest {
  //  public static void main(String[] args) {
   //     Map m=new TreeMap()
  //  }

    public void tryWithResources() throws FileNotFoundException {
//Java 8 and Below
        try(FileOutputStream post= new FileOutputStream("abc.text")) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Java 9 and above
       /* FileOutputStream post= new FileOutputStream("abc.text")
        try(post) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
    //non modifiable static factory method for set,list,map
    //max size is 10
   /* public void staticFactoryMethod(){
        Set<String> set=Set.of("kk","pk");
    }*/

    //ProcessAPi
   /* public void process(){
        ProcessPath.ProcessHandler ph= ProcessPath.ProcessHandler.cu
    }*/

}
