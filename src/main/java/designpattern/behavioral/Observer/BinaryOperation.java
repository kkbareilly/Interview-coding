package designpattern.behavioral.Observer;

public class BinaryOperation extends Observer {

    BinaryOperation(Subject subject){
        this.subject=subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {

    }
}
