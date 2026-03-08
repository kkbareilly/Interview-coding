package designpattern.behavioral.state;

import java.util.stream.StreamSupport;

public class Context {
    State state;

    public  Context(){
        this.state=null;
    }

    public void setState(State state){
        this.state=state;
    }

    public State getState(){
        return state;
    }
}
