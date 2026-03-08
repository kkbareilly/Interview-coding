package java17.switchs;

public class SwtichOps {
    public static void main(String[] args){
        String d="test";
        switch (d){
            case direction.NORTH,direction.SOUTH -> 5;
            default  -> 4;
        }
//with collon have to used yield to return value

        switch (d){
            case direction.NORTH,direction.SOUTH : yield 5;
            default : yield 4;
        }

        //preview feature in java 17
        switch (d){
            case String s & s.startsWith("A") -> System.out.println("String");
            case Integer i && i.intValue()>10; -> System.out.println("int");
            case null -> System.out.println("Null");
            default -> System.out.println("Not recognished")
        }
    }
}
enum direction{
    NORTH,SOUTH,EAST,WEST;
}