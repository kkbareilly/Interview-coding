package designpattern.creational.abstractfactory.os;

import designpattern.creational.abstractfactory.Button;

public class MacButton implements Button {
    @Override
    public void paint() {
    System.out.println("Mac Check Box");
    }
}
