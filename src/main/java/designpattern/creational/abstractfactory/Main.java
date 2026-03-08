package designpattern.creational.abstractfactory;

import designpattern.creational.abstractfactory.uifactory.WindowUiFactory;

public class Main {

    public static void main(String[] args){
        ApplicationFactory application=new ApplicationFactory(new WindowUiFactory());
        application.paint();;
    }
}
