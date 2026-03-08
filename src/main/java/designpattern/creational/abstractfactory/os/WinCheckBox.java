package designpattern.creational.abstractfactory.os;

import designpattern.creational.abstractfactory.CheckBox;

public class WinCheckBox implements CheckBox {
    @Override
    public void paint() {
    System.out.println(" Win CheckBox");
    }
}
