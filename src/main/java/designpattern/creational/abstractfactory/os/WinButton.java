package designpattern.creational.abstractfactory.os;

import designpattern.creational.abstractfactory.Button;

public class WinButton implements Button {
    @Override
    public void paint() {
    System.out.println("Windows Button");
    }
}
