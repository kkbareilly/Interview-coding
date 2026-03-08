package designpattern.creational.abstractfactory;

import designpattern.creational.abstractfactory.uifactory.UiFactory;

public class ApplicationFactory {

    Button button;
    CheckBox checkBox;

    public ApplicationFactory(UiFactory factory){
        this.button=factory.createButton();
        this.checkBox=factory.createCheckBox();

    }
    public void paint(){
        button.paint();;
        checkBox.paint();
    }
}
