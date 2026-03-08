package designpattern.behavioral.Observer;

public class OctOperation extends Observer {

    OctOperation(Subject subject){
        this.subject=subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {

    }
}
