package designpattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class PlayWithRemote {
    public static void main(String[] args) {
        ElectronicDevice device=TVRemove.getDevice();
        TurnTVOn on=new TurnTVOn(device);
        DeviceButton onPress=new DeviceButton(on);
        onPress.press();
        Television tv=new Television();
        Radio rd=new Radio();
        List<ElectronicDevice> deives=new ArrayList<>();
        deives.add(tv);
        deives.add(rd);
        TurnItAllOff off=new TurnItAllOff(deives);
        DeviceButton btn=new DeviceButton(off);
        btn.press();
    }
}
