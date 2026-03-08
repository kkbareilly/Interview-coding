package designpattern.creational.abstractfactory.os;

import designpattern.creational.abstractfactory.CheckBox;

public class MacCheckBox implements CheckBox {
    @Override
    public void paint() {
    System.out.println(" Mac CheckBox");
    }
}
