package designpattern.creational.abstractfactory.uifactory;

import designpattern.creational.abstractfactory.Button;
import designpattern.creational.abstractfactory.CheckBox;
import designpattern.creational.abstractfactory.os.MacButton;
import designpattern.creational.abstractfactory.os.MacCheckBox;
import designpattern.creational.abstractfactory.os.WinButton;
import designpattern.creational.abstractfactory.os.WinCheckBox;

public class MacUiFactory implements UiFactory {
    @Override
    public Button createButton() {

        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
    return new MacCheckBox()
            ;
    }
}
