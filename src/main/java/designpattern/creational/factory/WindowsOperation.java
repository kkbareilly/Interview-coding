package designpattern.creational.factory;

public class WindowsOperation extends OperatingSystem{
    public WindowsOperation(String version, String architecture) {
        super(version, architecture);
    }

    @Override
    public void changeDir(String dir) {

    }

    @Override
    public void removeDir(String dir) {

    }
}
