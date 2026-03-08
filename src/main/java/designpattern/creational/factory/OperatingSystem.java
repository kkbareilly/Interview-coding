package designpattern.creational.factory;

public abstract class  OperatingSystem {

    public String version;

    public String architecture;

    public OperatingSystem(String version, String architecture) {
        this.version = version;
        this.architecture = architecture;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }
    public abstract void changeDir(String dir);
    public abstract void removeDir(String dir);
}
