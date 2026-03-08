package designpattern.behavioral.state;

public class StopState implements State{
    @Override
    public void doAction(Context context) {
    System.out.println("Stop");
    context.setState(this);
    }
}
