package designpattern.behavioral.state;

public class StartState implements State{
    @Override
    public void doAction(Context context) {
    System.out.println("Started");
    context.setState(this);
    }
}
