package designpattern.behavioral.command;

public class TVRemove {
    public static ElectronicDevice getDevice(){
        return new Television();
    }
}
