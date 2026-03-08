package designpattern.creational.factory;

public class OperatingSystemFactory {

    private OperatingSystemFactory(){

    }

    public static OperatingSystem getInstance(String type, String version,String arch){
        switch (type){
            case  "WINDOWS":
                  return new WindowsOperation(version,arch);
            case  "MAC":
                return new MacOperations(version,arch);
            default:throw new IllegalArgumentException("Type parameter is not valid");
        }
    }
}
