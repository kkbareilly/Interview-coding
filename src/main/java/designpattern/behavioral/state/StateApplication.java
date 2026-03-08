package designpattern.behavioral.state;

public class StateApplication {

    public static void main(String[] args){
        Context context=new Context();
        StartState sta=new StartState();
        sta.doAction(context);
    System.out.println(context.getState());
        DoneState done=new DoneState();
        done.doAction(context);
        System.out.println(context.getState());
        StopState stp=new StopState();
        stp.doAction(context);
        System.out.println(context.getState());
    }
}
