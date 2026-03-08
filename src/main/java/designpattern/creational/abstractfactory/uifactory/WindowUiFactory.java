package designpattern.creational.abstractfactory.uifactory;

import designpattern.creational.abstractfactory.Button;
import designpattern.creational.abstractfactory.CheckBox;
import designpattern.creational.abstractfactory.os.WinButton;
import designpattern.creational.abstractfactory.os.WinCheckBox;

public class WindowUiFactory implements UiFactory {
    @Override
    public Button createButton() {
    return new WinButton();
    }

    @Override
    public CheckBox createCheckBox() {
    return new WinCheckBox();
    }
}
