package designpattern.creational.abstractfactory.uifactory;

import designpattern.creational.abstractfactory.Button;
import designpattern.creational.abstractfactory.CheckBox;


public interface UiFactory {

    public Button createButton();
    public CheckBox createCheckBox();
}
