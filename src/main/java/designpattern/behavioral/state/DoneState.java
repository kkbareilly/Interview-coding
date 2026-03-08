package designpattern.behavioral.state;

public class DoneState implements State{
    @Override
    public void doAction(Context context) {
    System.out.println("done");
    context.setState(this);
    }
}
