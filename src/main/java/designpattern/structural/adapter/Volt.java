package designpattern.structural.adapter;

public class Volt {
    public int volt;
    Volt(int volt){
        this.volt=volt;
    }
    public int getVolt(){
        return this.volt;
    }
    public String toString(){
        return "Volt [volt="+volt+"]";
    }
}
