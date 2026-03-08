package designpattern.behavioral.command;

import java.util.LinkedList;
import java.util.List;

public class TurnItAllOff implements Command{
    List<ElectronicDevice> theDevices;
    TurnItAllOff(List<ElectronicDevice> devices){
        theDevices=devices;
    }
    @Override
    public void execute() {
         for (ElectronicDevice device:theDevices){
             device.off();;
         }
    }
}
