package java8.files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReadDirectory {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("/Users/ksingh/Desktop/Loan");
        DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir, "*.*");
       Stream stream= Files.lines(dir);
        stream.forEach(f -> System.out.println(f));

        dirStream.forEach(f -> System.out.println(f.getFileName()));
    }

    public void readFIle(){
        Stream<String> stream = null;
        try{
            stream=Files.lines(Paths.get("file path"), StandardCharsets.UTF_8);

        }catch (Exception e){

        }
        List<String> words=new ArrayList<>();
       Stream<String> wordsDataStream= stream.flatMap(s->Stream.of(s.split(" +")));
       wordsDataStream.forEach(word->words.add(word));
    }
}

