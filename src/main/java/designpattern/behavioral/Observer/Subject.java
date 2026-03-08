package designpattern.behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    List<Observer> obs=new ArrayList<>();

    int state;

    private int getState(){
        return state;
    }
    public void setState(int state){
        this.state=state;
        notifyObs();
    }

    public void attach(Observer observer){
        obs.add(observer);
    }

    public void notifyObs(){
        for (Observer obr:obs){
            obr.update();
        }
    }
}
